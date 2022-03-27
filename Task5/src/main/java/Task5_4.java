/*        4) Создайте массив из int[] mass = new int[12]; Рандомно заполните его значениями от 0 до 15.
        Определите какой элемент является в этом массиве максимальным и сообщите индекс его последнего вхождения в массив.
        Пример: {3,4,5,62,7,8,4,-5,7,62,5,1} Максимальный элемент 62, индекс его последнего вхождения в массив = 10

 */

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task5_4 {

  public static void main(String[] args) {
    getArrayLastOccurIndex(arrayInt());
  }

  private static int[] arrayInt() {
    return IntStream.generate(() -> new Random()
            .nextInt(0, 16))
        .limit(12)
        .toArray();
  }

  private static void getArrayLastOccurIndex(int[] arr) {
    System.out.println(Arrays.toString(arr));
    System.out.println(
        "Максимальное значение массива: " + Arrays.stream(arr).max().getAsInt()
            + ", индекс последнего вхождения: "
            + Arrays.stream(arr).boxed().collect(Collectors.toList())
            .lastIndexOf(Arrays.stream(arr).max().getAsInt()));
  }
}
