package by.tms.textFormatter.model;

import by.tms.textFormatter.model.FileOperation.FileRead;
import by.tms.textFormatter.model.FileOperation.FileWrite;
import by.tms.textFormatter.utils.StringOperation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringReadWrite {

  private StringOperation stringOperation = new StringOperation();
  private FileRead fileRead = new FileRead();
  private FileWrite fileWrite = new FileWrite();
  private List<String> listInString;
  private List<String> listOutString = new ArrayList<>();

  public void loadListToFile() throws InputError, IOException {
    downloadFileToList(getListFromFile());
    System.out.println(toDoMessage());
    Scanner scanner = new Scanner(System.in);
    int numCase = scanner.nextInt();
    makeChoiceOfWrite(numCase);
  }

  private void downloadFileToList(List<String> inputList) throws InputError {
    if (!inputList.isEmpty()) {
      listInString = inputList;
    } else {
      throw new InputError("Файл пустой");
    }
  }

  private List<String> getListFromFile() throws InputError, IOException {
    return fileRead.readTextFileToList();
  }

  private String toDoMessage() {
    return """
        Выберите, что необходимо сделать с файлом:
        1. Записать в файл только полиндромы.
        2. Проверить и записать файл если кол-во слов 3-5 или есть хоть один полиндром.""";

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

  private void addPalindromeToList() {
    for (String value : listInString) {
      if (!stringOperation.isBlank(value.trim()) && stringOperation.isPalindrome(
          value.trim())) {
        listOutString.add(value);
      }
    }
  }

  private void addStringToList() {
    for (String readLine : listInString) {
      if (!stringOperation.isBlank(readLine) && (stringOperation.countingWords(readLine)
          || stringOperation.checkPalindrome(
          readLine.split(" ")))) {
        listOutString.add(readLine);
      }
    }
  }

  private void checkListAndWrite() throws InputError, IOException {
    if (!listOutString.isEmpty()) {
      fileWrite.writeListInFile(listOutString, "OutputList.txt");
    } else {
      throw new InputError("Список пуст или не соответствует требованиям");
    }
  }
}
