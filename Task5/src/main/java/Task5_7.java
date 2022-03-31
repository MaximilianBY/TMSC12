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
        int[] arrDublicates = new int[arrayInt().length];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > 1) {
                arrDublicates[i] = arr[i];
            } else {
                arrDublicates[i] = -1;
            }
        }
        System.out.print("Повторяющиеся элементы массива: ");
        for (int i = 1; i < arrDublicates.length; i++) {
            if (arrDublicates[i] != arrDublicates[i - 1] && arrDublicates[i - 1] != -1) {
                System.out.print(arrDublicates[i - 1] + " ");
            }
        }
    }
}
