package by.tms.calc_model;

public class CalculatorOperations {

  public static int calculations(int num1, int num2, String operator) {
    switch (operator) {
      case "-":
        return num1 - num2;
      case "+":
        return num1 + num2;
      case "*":
        return num1 * num2;
      case "/":
        return num1 / num2;
    }
    return 0;
  }
}
