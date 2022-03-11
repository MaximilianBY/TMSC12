package by.tms.textFormatter.model;

import java.util.regex.Pattern;

public class Matcher {

  private java.util.regex.Matcher matcher;

  public void setMatcher(Pattern pattern, String string) {
    this.matcher = pattern.matcher(string);
  }

  public void printMatches() {
    while (matcher.find()) {
      System.out.println(matcher.group());
    }
  }

  public void printString(by.tms.textFormatter.model.Pattern pattern, String string) {
    System.out.println(pattern.getPattern().split(string).length);
  }

  public boolean isEngSymbol(String string) {
    if (string.matches("(([a-z[1|5]]+){4,20}[^_])")) {
      return true;
    }
    return false;
  }
}
