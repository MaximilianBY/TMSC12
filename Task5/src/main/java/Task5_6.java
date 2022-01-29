//        6) Найти максимальный элемент в массиве {4,5,0,23,77,0,8,9,101,2} и поменять его местами с нулевым элементом

import java.util.Arrays;
import java.util.Random;

public class Task5_6 {
    public static void main(String[] args) {
        replaceCellArr(arrayInt());
    }

    private static int[] arrayInt() {
        int[] arrNum = new int[10];
        Random randomNum = new Random();
        for (int i = 0; i < 10; i++) {
            arrNum[i] = randomNum.nextInt(100);
        }
        return arrNum;
    }

    private static void replaceCellArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int tmp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int tmp2 = arr[0];
            int index = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > tmp) {
                    tmp = arr[j];
                    index = j;
                }
            }
            arr[0] = tmp;
            arr[index] = tmp2;
            break;
        }
        System.out.println(Arrays.toString(arr));
    }
}
