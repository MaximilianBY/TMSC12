package by.tms.text_formatter;

import java.util.regex.Pattern;

public class StringOperation {

  private static final String SYMBOL_MATCHER = ",.!@#%& ";
  private static final Pattern pattern = Pattern.compile(SYMBOL_MATCHER);

  public void midChar(String string) { //выводит средние символы строки с четной длиной
    if (string.length() % 2 == 0 && string.length() / 2 > 2) {
      System.out.println(string.substring(string.length() / 2 - 1, string.length() / 2 + 1));
    }
  }

  public void engABC(String string) { //ищем слова только из латинских букв
    String[] inArr = pattern.split(string);
    for (String value : inArr) {
      if (value.matches("\\w+")) {
        System.out.println(value);
      }
    }
  }

  public String printSubString(String string) { //выводит подстроку от А до В
    if (string.isEmpty() || string.isBlank()) {
      return "Строка не введена!";
    }
    return string.substring(string.indexOf('A'), string.lastIndexOf(
        'B'));
  }

  public String replaceChar(String string) { //заменяет символы в индексе 3 символами из индекса 0
    if (string.isEmpty() || string.isBlank()) {
      return "Строка не введена!";
    }
    return string.replace(string.charAt(3), string.charAt(0));
  }

  private boolean isPalindrome(String value) { //проверяем является ли слово полиндромом
    StringBuilder stringBuilder = new StringBuilder(value);
    if (String.valueOf(stringBuilder.reverse()).equals(value)) {
      return true;
    }
    return false;
  }

  public void printPalindromes(String string) { // выводим только слова полиндромы
    String[] inArr = pattern.split(string);
    for (String value : inArr) {
      if (isPalindrome(value)) {
        System.out.println(value);
      }
    }
  }

  private boolean checkPalindrome(
      String[] inArr) { //проверяем, есть ли в массиве хоть одно слово полиндром
    for (String value : inArr) {
      if (isPalindrome(value)) {
        return true;
      }
    }
    return false;
  }

  public void printStr(String inStr) { // выводим строку на экран
    if (inStr.isEmpty() || inStr.isBlank() || inStr == null) {
      System.out.println("Строка не введена!");
    } else {
      String[] inArr = pattern.split(inStr);
      if (inArr.length >= 3 && inArr.length <= 5 || checkPalindrome(inArr)) {
        System.out.println(inStr);
        System.out.println("В строке присутствует слово полиндром? " + checkPalindrome(inArr));
      } else {
        System.out.println("Строка не соответствует требованиям");
      }
    }
  }
}
