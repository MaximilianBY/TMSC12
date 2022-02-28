public class StringOperation {

  private String string;

  public StringOperation(String string) {
    this.string = string;
  }

  public StringOperation() {
  }

  public String printSubString() {
    if (string.isEmpty() || string.isBlank()) {
      return "Строка не введена!";
    }
    return string.substring(string.indexOf('A'), string.lastIndexOf(
        'B')); //тут можно было бы сделать с учетом регистра через регулярку, но решил оставить как есть
  }

  public String replaceChar() {
    if (string.isEmpty() || string.isBlank()) {
      return "Строка не введена!";
    }
    return string.replace(string.charAt(3), string.charAt(
        0)); //тут не совсем понятно мне, возможно надо, чтобы предложение было целым, без пробелов
  }

  private boolean isPalindrome(String[] inArr) {
    if (inArr == null) {
      System.out.println("Массив не задан");
      return false;
    }
    for (String value : inArr) {
      StringBuilder stringBuilder = new StringBuilder(value);
      if (String.valueOf(stringBuilder.reverse()).equals(value)) {
        return true;
      }
    }
    return false;
  }

  public void printPalindromes(String[] inArr) {
    if (inArr == null) {
      System.out.println("Массив не задан");
    } else {
      if (isPalindrome(inArr)) {
        for (String value : inArr) {
          StringBuilder stringBuilder = new StringBuilder(value);
          if (String.valueOf(stringBuilder.reverse()).equals(value)) {
            System.out.println(value);
          }
        }
      }
    }
  }

  public void printStr(String inStr) {
    if (inStr.isEmpty() || inStr.isBlank()) {
      System.out.println("Строка не введена!");
    } else {
      String[] arrStr = inStr.split("\\.");
      if (arrStr.length >= 3 && arrStr.length <= 5 || isPalindrome(arrStr)) {
        for (String value : arrStr) {
          System.out.println(value);
        }
      } else {
        System.out.println("Строка не соответствует требованиям");
      }
    }
  }

  public String getString() {
    return string;
  }
}
