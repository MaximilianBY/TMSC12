package by.tms.censure.model;

import by.tms.text_formatter.model.FileOperation.FileRead;
import by.tms.text_formatter.model.InputError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringOperation {

  private static final String[] BLACK_LIST = {".*аш.*", ".*чер.*", ".*ell.*"};
  private FileRead fileRead = new FileRead();
  private List<String> listInputString;

  private boolean checkString(String inputString) {
    for (String value : BLACK_LIST) {
      if (inputString.matches(value)) {
        return true;
      }
    }
    return false;
  }

  public List<String> getListFromFile() throws InputError, IOException {
    return fileRead.readTextFileToList();
  }

  public void downloadFileToList(List<String> inputList) throws InputError {
    if (!inputList.isEmpty()) {
      listInputString = inputList;
    } else {
      throw new InputError("Файл пустой");
    }
  }

  private List<String> countBadString() {
    List<String> listBadString = new ArrayList<>();
    for (String readLine : listInputString) {
      int countBadElement = 0;
      for (String elementLine : readLine.split(" ")) {
        if (checkString(elementLine)) {
          countBadElement++;
        }
      }
      if (countBadElement > 0) {
        listBadString.add(readLine);
      }
    }
    return listBadString;
  }

  public void printMessage() {
    if (countBadString().size() > 0) {
      System.out.println(
          "Текст не прошел проверку, количество нецензурных строк: " + countBadString().size()
              + ". Исправьте следующие строки: ");
      for (String value : countBadString()) {
        System.out.println(value);
      }
    } else {
      System.out.println("Текст прошел проверку!");
    }
  }
}
