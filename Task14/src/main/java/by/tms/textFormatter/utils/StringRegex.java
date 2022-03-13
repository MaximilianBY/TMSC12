package by.tms.textFormatter.utils;

import lombok.experimental.UtilityClass;

@UtilityClass

public final class StringRegex {

  public static final String STRING_PAT = "(([c]){1,3}([a]){1}([b]){1})"; //можно и [c+ab], но если в такой форме задать, то будет выводить каждую букву построчно
  public static final String STRING_JAVA_VER = "([Jj][Aa][Vv][Aa][ ]*[\\d]*)";
  public static final String COUNT_ENG_WORDS = "((?=[a-z|[A-Z]]+)[^а-я|[А-Я]0-9]+)";
}
