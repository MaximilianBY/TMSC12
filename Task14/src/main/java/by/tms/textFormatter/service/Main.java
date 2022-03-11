package by.tms.textFormatter.service;

import by.tms.textFormatter.model.InputError;
import by.tms.textFormatter.model.StringReadWrite;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    StringReadWrite stringReadWrite = new StringReadWrite();
    try {
      stringReadWrite.loadListToFile();
    } catch (InputError e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
