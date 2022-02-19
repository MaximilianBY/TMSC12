package by.tms.library.model;

import by.tms.library.model.service.Author;
import by.tms.library.model.service.Library;
import by.tms.library.model.service.Reader;
import java.util.Map.Entry;

public class Main {

  public static void main(String[] args) {
    Library library = new Library();
    library.setListLibrary(new Author("Марк Твен", "Приключения Тома Сойера"));
    library.setListLibrary(new Author("Марк Твен", "Приключения Тома Сойера"));
    library.setListLibrary(new Author("Марк Твен", "Приключения Гекльберри Финна"));
    library.setListLibrary(new Author("Марк Твен", "Жизнь на Миссисипи"));
    library.setListLibrary(new Author("Марк Твен", "Простаки за границей"));
    library.setListLibrary(new Author("Лев Толстой", "Война и мир том 1"));
    library.setListLibrary(new Author("Лев Толстой", "Война и мир том 2"));
    library.setListLibrary(new Author("Лев Толстой", "Смерть Ивана Ильича"));
    library.setListLibrary(
        new Author("Дейл Карнеги", "Как завоевывать друзей и оказывать влияние на людей"));
    library.setListReader(new Reader("Иван", "02.06.1996", "+375293547682", 1, "Экономика"));
    library.setListReader(new Reader("Дмитрий", "21.02.1994", "+375256587682", 2,
        "Банковское право"));
    library.greetings();
    for (Entry<Integer, Author> pair : library.getListBorrowedBook().entrySet()) {
      System.out.println(pair.getKey() + " " + pair.getValue().getTitle());
    }
    library.greetings();
    for (Entry<Integer, Author> pair : library.getListBorrowedBook().entrySet()) {
      System.out.println(pair.getKey() + " " + pair.getValue().getTitle());
    }
  }
}
