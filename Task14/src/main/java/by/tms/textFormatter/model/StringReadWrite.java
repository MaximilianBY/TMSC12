package by.tms.textFormatter.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringReadWrite {

  private StringOperation stringOperation = new StringOperation();
  private FileOperation fileOperation = new FileOperation();
  private List<String> listInString;
  private List<String> listOutString = new ArrayList<>();

  public void downloadFileToList(List<String> inputList) throws InputError {
    if (!inputList.isEmpty()) {
      listInString = inputList;
    } else {
      throw new InputError("Файл пустой");
    }
  }

  public List<String> getListFromFile() throws InputError, IOException {
    return fileOperation.fileRead.readTextFileToList();
  }

  private void addPalindromeToList() {
    for (String value : listInString) {
      if (!stringOperation.checkString(value.trim()) && stringOperation.isPalindrome(
          value.trim())) {
        listOutString.add(value);
      }
    }
  }

  private void addStringToList() {
    for (String readLine : listInString) {
      if (!stringOperation.checkString(readLine) && (stringOperation.countingWords(readLine)
          || stringOperation.checkPalindrome(
          readLine.split(" ")))) {
        listOutString.add(readLine);
      }
    }
  }

  private String toDoMessage() {
    return """
        Выберите, что необходимо сделать с файлом:
        1. Записать в файл только полиндромы.
        2. Проверить и записать файл если кол-во слов 3-5 или есть хоть один полиндром.""";

  }

  private void checkListAndWrite() throws InputError, IOException {
    if (!listOutString.isEmpty()) {
      fileOperation.fileWrite.writeListInFile(listOutString, "OutputList.txt");
    } else {
      throw new InputError("Список пуст или не соответствует требованиям");
    }
  }

  private void makeChoiceOfWrite(int numCase) throws InputError, IOException {
    switch (numCase) {
      case 1: {
        addPalindromeToList();
        checkListAndWrite();
        break;
      }
      case 2: {
        addStringToList();
        checkListAndWrite();
        break;
      }
      default: {
        throw new InputError("Выбрано неверное действие");
      }
    }
  }

  public void loadListToFile() throws InputError, IOException {
    System.out.println(toDoMessage());
    Scanner numCase = new Scanner(System.in);
    makeChoiceOfWrite(numCase.nextInt());
  }
}
