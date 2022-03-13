package by.tms.censure.main;

import by.tms.censure.model.StringOperation;
import by.tms.text_formatter.model.InputError;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    StringOperation stringOperation = new StringOperation();
    try {
      stringOperation.downloadFileToList(stringOperation.getListFromFile());
      stringOperation.printMessage();
    } catch (InputError e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {

    }
  }
}
