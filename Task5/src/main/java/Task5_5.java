/*        5) Создайте массив размера 20, заполните его случайными целыми чиселами из отрезка от 0 до 20.
        Выведите массив на экран в строку. Замените каждый элемент с нечётным индексом на ноль.
        Снова выведете массив на экран на отдельной строке.

 */

import java.util.Arrays;

public class Task5_5 {
    public static void main(String[] args) {
        replaceCellArr(arrayInt());
    }

    private static int[] arrayInt() {
        int[] arrNum = new int[20];
        for (int i = 0; i < 20; i++) {
            arrNum[i] = (int) (Math.random() * 21);
        }
        return arrNum;
    }

    private static void replaceCellArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }
}
