/*        3) Создайте массив из всех нечётных чисел от 1 до 100, выведите его на экран в строку,
        а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 ... 7 5 3 1).


 */

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Task5_3 {

  public static void main(String[] args) {
    int[] arr = arrayNum();
    arrayUp(arr);
    arrayDown(arr);
  }

  private static int[] arrayNum() {
    return IntStream.generate(() -> new Random()
            .nextInt(1, 100))
        .distinct()
        .limit(50)
        .sorted()
        .filter(i -> i % 2 != 0)
        .toArray();
  }

  private static void arrayUp(int[] arr) {
    Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
  }

  private static void arrayDown(int[] arr) {
    System.out.println();
    for (int i = arr.length - 1; i >= 0; i--) {
      System.out.print(arr[i] + " ");
    }
  }
}
