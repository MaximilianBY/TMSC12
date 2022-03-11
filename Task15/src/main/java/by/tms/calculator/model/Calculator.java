package by.tms.calculator.model;

public class Calculator {

  public static <T extends Number, V extends Number> void sum(T t, V v) {
    System.out.println(t.intValue() + v.doubleValue());
  }

  public static <T extends Number, V extends Number> void multiply(T t, V v) {
    System.out.println(t.intValue() * v.doubleValue());
  }

  public static <T extends Number, V extends Number> void divide(T t, V v) {
    System.out.println(t.intValue() / v.doubleValue());
  }

  public static <T extends Number, V extends Number> void subtraction(T t, V v) {
    System.out.println(t.intValue() - v.doubleValue());
  }
}
