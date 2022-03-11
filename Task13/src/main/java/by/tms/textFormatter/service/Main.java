package by.tms.textFormatter.service;

import by.tms.textFormatter.StringOperation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringOperation str1 = new StringOperation();
    System.out.println(str1.printSubString(reader.readLine()));
    System.out.println(str1.replaceChar(reader.readLine()));
//    заказ, казак, дед, дом, vrarv, home, computer
    str1.printPalindromes(reader.readLine());
    str1.printStr(reader.readLine());
    str1.midChar(reader.readLine());
    str1.engABC(reader.readLine());
  }
}
