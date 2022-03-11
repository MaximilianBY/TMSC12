package by.tms.textFormatter.model;

public class StringIn {

  private String inString;

  public void midChar(String string) {
    if (string.length() % 2 == 0 && string.length() / 2 > 2) {
      System.out.println(string.substring(string.length() / 2 - 1, string.length() / 2 + 1));
    }
  }
}
