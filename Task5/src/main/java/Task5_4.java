/*        4) Создайте массив из int[] mass = new int[12]; Рандомно заполните его значениями от 0 до 15.
        Определите какой элемент является в этом массиве максимальным и сообщите индекс его последнего вхождения в массив.
        Пример: {3,4,5,62,7,8,4,-5,7,62,5,1} Максимальный элемент 62, индекс его последнего вхождения в массив = 10

 */

import java.util.Arrays;

public class Task5_4 {
    public static void main(String[] args) {
        getArrayLastOccurIndex(arrayInt());
    }

    private static int[] arrayInt() {
        int[] arrNum = new int[15];
        for (int i = 0; i < 15; i++) {
            arrNum[i] = (int) (Math.random() * 16);
        }
        return arrNum;
    }

    private static void getArrayLastOccurIndex(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int index = -1, maxNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxNum) {
                maxNum = arr[i];
                index = i;
            }
        }
        System.out.println("Максимальное значение массива: " + maxNum + ", индекс последнего вхождения: " + index);
    }
}
