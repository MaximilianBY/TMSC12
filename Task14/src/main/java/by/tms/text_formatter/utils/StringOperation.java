package by.tms.text_formatter.utils;

public final class StringOperation {

  public boolean isPalindrome(String value) {//проверяем является ли слово полиндромом
    StringBuilder stringBuilder = new StringBuilder(value);
    if (value.length() > 2 && stringBuilder.reverse().toString().equalsIgnoreCase(value)) {
      return true;
    }
    return false;
  }

  //мне почему-то кажется, что в случае с русскими символами, сплит отработает неправильно и метод никогда не отработает
  public boolean countingWords(String string) {
    String[] inputListString = string.split("[\\S\\s]");
    return inputListString.length >= 3 && inputListString.length <= 5;
  }

  public boolean isBlank(String inputString) {
    return inputString == null && inputString.isEmpty() && inputString.isBlank();
  }

  public boolean checkPalindrome(String[] inputString) {
    for (String value : inputString) {
      if (isPalindrome(value)) {
        return true;
      }
    }
    return false;
  }
}
