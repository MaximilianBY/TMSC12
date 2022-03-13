package by.tms.textFormatter.service;

import by.tms.textFormatter.model.Matcher;
import by.tms.textFormatter.utils.StringRegex;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
//    try {
//      StringReadWrite stringReadWrite = new StringReadWrite();
//      stringReadWrite.loadListToFile();
//    } catch (InputError e) {
//      System.out.println(e.getMessage());
//    } catch (IOException e) {
//      e.printStackTrace();
//    }

//    StringIn stringIn = new StringIn();
//    stringIn.midChar("Казака");
    String stringCAB = "sdfdsfcabsdff dgdfccabfdrt bcvcccccccabfghgher323";
    String stringJAVAVer = "Versions: Java  5, Java 6, Java   7, Java 8, Java 12.";
    String stringENG = "Oneфыв two three раз два три one1 two2 123 ";
    String stringEngSymbl = "fgdsghfdgfd5";
    by.tms.textFormatter.model.Pattern patternCAB = new by.tms.textFormatter.model.Pattern();
    by.tms.textFormatter.model.Pattern patternJAVA = new by.tms.textFormatter.model.Pattern();
    by.tms.textFormatter.model.Pattern patternENG = new by.tms.textFormatter.model.Pattern();
    patternCAB.setPattern(Pattern.compile(StringRegex.STRING_PAT));
    patternJAVA.setPattern(Pattern.compile(StringRegex.STRING_JAVA_VER));
    patternENG.setPattern(Pattern.compile(StringRegex.COUNT_ENG_WORDS));
    Matcher matcher = new Matcher();
//    matcher.setMatcher(patternCAB.getPattern(), stringCAB);
//    matcher.printMatches();
//    matcher.setMatcher(patternJAVA.getPattern(), stringJAVAVer);
//    matcher.printMatches();
//    matcher.setMatcher(patternENG.getPattern(), stringENG);
//    matcher.printMatches();
//    matcher.printString(patternENG, stringENG);
    System.out.println(matcher.isEngSymbol(stringEngSymbl));
  }
}
