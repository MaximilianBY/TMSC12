import java.util.Random;
import java.util.Scanner;

/*
Создать матрицу размера 10 на 10 и заполнить ее случайными целочислеными значениями (тип int) из диапазона от 0 до 10000.
Найти максимум среди сумм трех соседних элементов в строке. Для найденной тройки с максимальной суммой выведите значение суммы и индексы(i,j) первого элемента тройки.
Пример:
*Для простоты пример показан на одномерном массиве размера 10
[1, 456, 1025, 65, 954, 2789, 4, 8742, 1040, 3254] Тройка с максимальной суммой:  [2789, 4, 8742]
Вывод в консоль:
11535 (0,5)
*Пояснение. Первое число - сумма тройки  [2789, 4, 8742]. Числа в скобках это 0 строка и 5 столбец - индекс первого элемента тройки, то есть индекс числа 2789.
 */
public class Task5_bonus {
    public static void main(String[] args) {
        System.out.println("Введите параметры матрицы: ");
        maxSumCells(matrixCreator());
    }

    private static void maxSumCells(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int sumItog = 0;
        int indexStroke = 0, indexColumn = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int sumProv = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2];
                if (sumItog < sumProv) {
                    sumItog = sumProv;
                    indexStroke = i;
                    indexColumn = j;
                }
            }
        }
        System.out.println(sumItog + " (" + indexStroke + ", " + indexColumn + ")");
    }

    private static int[][] matrixCreator() {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[scanner.nextInt()][scanner.nextInt()];
        Random randomNum = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = randomNum.nextInt(10000);
            }
        }
        return matrix;
    }
}
