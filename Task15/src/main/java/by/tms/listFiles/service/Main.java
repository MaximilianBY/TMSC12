package by.tms.listFiles.service;

import by.tms.listFiles.model.RootOperation;

public class Main {

  public static void main(String[] args) {
    RootOperation rootOperation = new RootOperation();
    rootOperation.listFileInDir(rootOperation.getListDir());
    rootOperation.printFiles();
  }
}
