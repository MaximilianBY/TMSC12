/*
        1) Напишите реализацию метода summ(int a, int b), вычисляющий a*b, не пользуясь операцией
        умножения, где a и b целые числа, вызовите метод summ  в методе main и распечатайте на консоль.
 */

public class Task5_1 {
    public static void main(String[] args) {
        System.out.println(summ(-2, 0));
        System.out.println(summ2(-2, 3));
    }

    private static int summ(int a, int b) {
        int result = 0;
        if (a == 0 || b == 0) {
            return 0;
        } else if (a < 0 && b < 0) {
            a = -1 * a;
        } else if (a > 0 || b < 0) {
            a = -1 * a;
        }
        for (int i = 0; i < Math.abs(b); i++) {
            result += a;
        }
        return result;
    }

    private static int summ2(int a, int b) {
        int result = 0;
        if (a == 0 || b == 0) {
            return 0;
        } else if (a < 0 && b < 0) {
            b = -1 * b;
            a = -1 * a;
        } else if (a > 0 && b < 0) {
            b = -1 * b;
            a = -1 * a;
        }
        while (true) {
            if (b == 0) {
                break;
            }
            result += a;
            b--;
        }
        return result;
    }
}
