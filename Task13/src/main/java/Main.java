public class Main {

  public static void main(String[] args) {
    StringOperation str1 = new StringOperation("dfagASd fgh trhD BHjghe");
    System.out.println(str1.printSubString());
    System.out.println(str1.replaceChar());

    StringOperation str2 = new StringOperation();
    String arrPalindromes = "заказ, казак, дед, дом, vrarv, home, computer";
    str2.printPalindromes(arrPalindromes.split(
        "\\S\\s")); //я не смог разобраться, хотел кинуть на сплит все возможные символы разделения слов, но тогда он перестает выводить что-либо на экран

    str2.printStr("fsgsfd.sdfter.ergf.sdfb.tyu");
  }


}
