package by.tms.text_formatter.service;

import static by.tms.text_formatter.utils.StringRegex.COUNT_ENG_WORDS;
import static by.tms.text_formatter.utils.StringRegex.STRING_JAVA_VER;
import static by.tms.text_formatter.utils.StringRegex.STRING_PAT;

import by.tms.text_formatter.model.PrintStrings;
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
    String stringJavaVer = "Versions: Java  5, Java 6, Java   17, Java 8, Java 12.";
    String stringENG = "Oneфыв two three раз два три one1 two2 123 ";
    String stringEngSymbl = "fgds5ghfdgfd5";
    PrintStrings printStrings = new PrintStrings();
    printStrings.printMatches(Pattern.compile(STRING_PAT).matcher(stringCAB));
    printStrings.printMatches(Pattern.compile(STRING_JAVA_VER).matcher(stringJavaVer));
    printStrings.printMatches(Pattern.compile(COUNT_ENG_WORDS).matcher(stringENG));
    System.out.println(printStrings.isEngSymbol(stringEngSymbl));
  }
}
