/*
        1) Напишите реализацию метода summ(int a, int b), вычисляющий a*b, не пользуясь операцией
        умножения, где a и b целые числа, вызовите метод summ  в методе main и распечатайте на консоль.
 */

public class Task5_1 {
    public static void main(String[] args) {
        System.out.println(summ(-10, 6));
        System.out.println(summ2(5, 6));
    }

    private static int summ(int a, int b) {
        int result = 0;
        if (a == 0 || b == 0) {
            return 0;
        } else if (a < 0 && b > 0) {
            for (int i = 0; i < b; i++) {
                result += a;
            }
        } else if (a > 0 && b < 0) {
            for (int i = 0; i < a; i++) {
                result += b;
            }
        } else if (a < 0) {
            for (int i = 0; i > b; i--) {
                result -= a;
            }
        }
        return result;
    }

    private static int summ2(int a, int b) {
        int result = 0;
        if (a == 0 || b == 0) {
            return 0;
        }
        while (Math.abs(b) != 0) {
            result -= a;
            b++;
        }
        return result;
    }
}
