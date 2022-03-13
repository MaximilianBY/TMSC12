package by.tms.text_formatter.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintStrings {

  public void printMatches(Matcher matcher) {
    while (matcher.find()) {
      System.out.println(matcher.group());
    }
  }

  public void printString(Pattern pattern, String string) {
    System.out.println(pattern.split(string).length);
  }

  public boolean isEngSymbol(String string) {
    if (string.matches("(([a-z[15]]){4,20}[\\S])")) {
      return true;
    }
    return false;
  }
}
