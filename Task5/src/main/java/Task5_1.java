/*
        1) Напишите реализацию метода summ(int a, int b), вычисляющий a*b, не пользуясь операцией
        умножения, где a и b целые числа, вызовите метод summ  в методе main и распечатайте на консоль.
 */

import java.math.BigInteger;

public class Task5_1 {
    public static void main(String[] args) {
        System.out.println(summ(2, 3));
        System.out.println(summ2(2, 3));
        System.out.println(summ3("6", "2"));
    }

    private static int summ(int a, int b) {
        int result = 0;
        for (int i = 0; i < b; i++) {
            result += a;
        }
        return result;
    }

    private static int summ2(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    private static BigInteger summ3(String a, String b) {
        BigInteger num1 = new BigInteger(a);
        BigInteger num2 = new BigInteger(b);
        return num1.multiply(num2);
    }
}
