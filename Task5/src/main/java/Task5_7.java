/*        7) Проверить, различны ли все элементы массива, если не различны то вывести элемент повторяющийся
        Пример: {0,3,46,3,2,1,2}
        Массив имеет повторяющиеся элементы 3, 2
        Пример: {0,34,46,31,20,1,28}
        Массив не имеет повторяющихся элементов

 */

import java.util.Arrays;
import java.util.Random;

public class Task5_7 {
    public static void main(String[] args) {
        countDublicates(arrayInt());
    }

    private static int[] arrayInt() {
        int[] arrNum = new int[10];
        Random randomNum = new Random();
        for (int i = 0; i < 10; i++) {
            arrNum[i] = randomNum.nextInt(10);
        }
        return arrNum;
    }

    private static void countDublicates(int[] arr) {
        System.out.println(Arrays.toString(arr));
        System.out.print("Повторяющиеся элементы массива: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (j < arr.length && arr[i] == arr[j] && !Arrays.equals(arr, 0, i, arr, j, j)) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }
}
