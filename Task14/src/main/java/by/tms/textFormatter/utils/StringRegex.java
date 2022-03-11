package by.tms.textFormatter.utils;

public interface StringRegex {

  String STRING_PAT = "(([c]){1,3}([a]){1}([b]){1})";
  String STRING_JAVA_VER = "([Jj][Aa][Vv][Aa][ ]*[0-9])";
  String COUNT_ENG_WORDS = "((?=[a-z|[A-Z]]+)[^а-я|[А-Я]0-9]+)";
}
