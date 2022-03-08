package by.tms.censure.model;

import by.tms.textFormatter.model.FileOperation;
import by.tms.textFormatter.model.InputError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringOperation {

  private static final String[] BLACK_LIST = {".*аш.*", ".*чер.*", ".*ell.*"};
  private FileOperation fileOperation = new FileOperation();
  private int numOfBadWords;
  private List<String> listInputString;
  private List<String> listBadString = new ArrayList<>();

  private boolean checkString(String inputString) {
    for (String value : BLACK_LIST) {
      if (inputString.matches(value)) {
        return true;
      }
    }
    return false;
  }

  public List<String> getListFromFile() throws InputError, IOException {
    return fileOperation.fileRead.readTextFileToList();
  }

  public void downloadFileToList(List<String> inputList) throws InputError {
    if (!inputList.isEmpty()) {
      listInputString = inputList;
    } else {
      throw new InputError("Файл пустой");
    }
  }

  private void countBadString() {
    numOfBadWords = 0;
    for (String readLine : listInputString) {
      int countBadElement = 0;
      for (String elementLine : readLine.split(" ")) {
        if (checkString(elementLine)) {
          numOfBadWords++;
          countBadElement++;
        }
      }
      if (countBadElement > 0) {
        listBadString.add(readLine);
      }
    }
  }

  public void printMessage() {
    countBadString();
    if (numOfBadWords > 0) {
      System.out.println("Текст не прошел проверку, количество нецензурных слов: " + numOfBadWords
          + ". Исправьте следующие строки: ");
      for (String value : listBadString) {
        System.out.println(value);
      }
    } else {
      System.out.println("Текст прошел проверку!");
    }
  }
}
