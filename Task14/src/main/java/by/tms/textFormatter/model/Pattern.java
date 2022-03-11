package by.tms.textFormatter.model;

import by.tms.textFormatter.utils.StringRegex;

public class Pattern implements StringRegex {

  private java.util.regex.Pattern pattern;

  public java.util.regex.Pattern getPattern() {
    return pattern;
  }

  public void setPattern(java.util.regex.Pattern pattern) {
    this.pattern = pattern;
  }
}
