/*        8) Создаём квадратную матрицу, размер вводим с клавиатуры.
        Заполняем случайными числами в диапазоне от 0 до 50. И выводим на консоль(в виде матрицы).
        Далее необходимо транспонировать матрицу(1 столбец станет 1-й строкой, 2-й столбец - 2-й строкой и т. д.)
        Пример:
          1 2 3 4      1 6 3 1
          6 7 8 9      2 7 3 5
          3 3 4 5      3 8 4 6
          1 5 6 7      4 9 5 7

 */

import java.util.Random;
import java.util.Scanner;

public class Task5_8 {
    public static void main(String[] args) {
        transponMatrix(matrix());
    }

    private static int[][] matrix() {
        System.out.println("Введите целое положительное число для определения размеров матрицы: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[][] matrix = new int[a][a];
        Random randomNum = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = randomNum.nextInt(51);
            }
        }
        return matrix;
    }

    private static void transponMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
