import java.util.Random;
import java.util.Scanner;

public class Task5_9 {
    public static void main(String[] args) {
        System.out.println("Введите параметры матрицы, для подсчета суммы главной диагонали: ");
        calculateSumOfDiagonalElements(matrixCreator());
        System.out.println();
        System.out.println("Введите параметры матрицы, для вывода матрицы: ");
        printMatrix(matrixCreatorString());

    }

    /**
     * заполнить рандомно 2-х мерный массив и посчитать сумму элементов на диагонали
     */
    private static void calculateSumOfDiagonalElements(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }//пишем логику и выводим результат используя System.out.println
        }
        System.out.println("Сумма диагонали равна: " + sum);
    }

    /**
     * Шаги по реализации:
     * - Прочитать два int из консоли
     * - Создайте двумерный массив int (используйте целые числа, которые вы читаете по высоте и ширине консоли)
     * - Заполнить массив случайными значениями (до 100)
     * - Вывести в консоль матрицу заданного размера, но:
     * - Если остаток от деления элемента массива на 3 равен нулю - выведите знак "+" вместо значения элемента массива.
     * - Если остаток от деления элемента массива на 7 равен нулю - выведите знак "-" вместо значения элемента массива.
     * - В противном случае выведите "*"
     * <p>
     * Example:
     * - Значения с консоли - 2 и 3
     * - Массив будет выглядеть так (значения будут разными, потому что он случайный)
     * 6 11 123
     * 1 14 21
     * - Для этого значения вывод в консоли должен быть:
     * <p>
     * + * *
     * * - +
     * <p>
     * Обратите внимание, что 21% 3 == 0 и 21% 7 = 0, но выводить надо не +-, а +
     */
    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (Integer.parseInt(matrix[i][j]) % 3 == 0) {
                    matrix[i][j] = "+";
                } else if (Integer.parseInt(matrix[i][j]) % 7 == 0) {
                    matrix[i][j] = "-";
                } else {
                    matrix[i][j] = "*";
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] matrixCreator() {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[scanner.nextInt()][scanner.nextInt()];
        Random randomNum = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = randomNum.nextInt(100);
            }
        }
        return matrix;
    }

    private static String[][] matrixCreatorString() {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = new String[scanner.nextInt()][scanner.nextInt()];
        Random randomNum = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = String.valueOf(randomNum.nextInt(100));
            }
        }
        return matrix;
    }
}
