package by.tms.library.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Library {

  private List<Author> listLibrary = new ArrayList<>();
  private List<Reader> listReader = new ArrayList<>();
  private Map<Integer, Author> listBorrowedBook = new HashMap<>();
  Scanner scanner = new Scanner(System.in);

  public void greetings() {
    System.out.println("Добрый день!");
    System.out.println("""
        У Вас есть читательский билет?
        1. Да.
        2. Нет.""");
    checkReader();
  }

  private void checkReader() {
    if (Integer.parseInt(scanner.nextLine()) == 1) {
      System.out.println("Сообщите Ваш номер читательского билета: ");
      int ID = Integer.parseInt(scanner.nextLine());
      for (Reader reader : listReader) {
        if (reader.getTicketID() == ID) {
          makeChoose(reader.getName(), ID);
          break;
        }
      }
    } else {
      registration();
    }
  }

  public void makeChoose(String reader, int ID) {
    System.out.println(
        reader + ", что желаете сделать? \n 1. Взять книгу? \n 2. Сдать книгу?");
    if (Integer.parseInt(scanner.nextLine()) == 1) {
      takeBook(ID);
    } else {
      returnBook(ID);
    }
  }

  private void registration() {
    System.out.println("Пройдите регистрацию и получите свой читательский билет!");
    System.out.println("Введите данные в следующем порядке:");
    System.out.println("1. ФИО");
    String name = scanner.nextLine();
    System.out.println("2. Дата рождения в формате dd.mm.yyyy");
    String dateBirth = scanner.nextLine();
    System.out.println("3. Номер телефона начинающийся с кода");
    String phoneNumber = "+375 " + scanner.nextLine();
    int numID = listReader.size();
    System.out.println("4. Номер билета указанный сотрудником библиотеки: номер Вашего билета: " +
        ++numID);
    int ticketID = Integer.parseInt(scanner.nextLine());
    System.out.println("5. Факультет");
    String faculty = scanner.nextLine();
    listReader.add(new Reader(name, dateBirth, phoneNumber, ticketID, faculty));
    makeChoose(name, ticketID);
  }

  public void takeBook(int ID) {
    System.out.println("Какую книгу желаете взять?");
    getListLibrary();
    int numBook = Integer.parseInt(scanner.nextLine());
    listBorrowedBook.put(ID, listLibrary.get(numBook - 1));
    listLibrary.remove(numBook);
  }

  public void getListLibrary() {
    int count = 1;
    for (Author title : listLibrary) {
      System.out.println(count + ". " + title.getTitle());
      count++;
    }
  }

  public void returnBook(int ID) {
    System.out.println("Спасибо, что вернули книгу!");
    listLibrary.add(listBorrowedBook.get(ID));
    listBorrowedBook.remove(ID, listBorrowedBook.get(ID));
  }

  public void setListReader(Reader reader) {
    listReader.add(reader);
  }

  public void setListLibrary(Author author) {
    this.listLibrary.add(author);
  }

  public Map<Integer, Author> getListBorrowedBook() {
    return listBorrowedBook;
  }
}
