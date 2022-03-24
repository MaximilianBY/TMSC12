//        6) Найти максимальный элемент в массиве {4,5,0,23,77,0,8,9,101,2} и поменять его местами с нулевым элементом

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Task5_6 {
    public static void main(String[] args) {
        replaceCellArr(arrayInt());
    }

    private static int[] arrayInt() {
        return IntStream.generate(() -> new Random().nextInt(100))
            .limit(10)
            .toArray();
    }

    private static void replaceCellArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int tmp = 0;
        int tmp2 = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > tmp) {
                tmp = arr[i];
                index = i;
            }
        }
        arr[0] = tmp;
        arr[index] = tmp2;
        System.out.println(Arrays.toString(arr));
    }
}
