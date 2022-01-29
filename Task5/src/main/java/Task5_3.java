/*        3) Создайте массив из всех нечётных чисел от 1 до 100, выведите его на экран в строку,
        а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 ... 7 5 3 1).


 */

public class Task5_3 {
    public static void main(String[] args) {
        arrayUp(arrayNum());
        arrayDown(arrayNum());
    }

    private static int[] arrayNum() {
        int[] nums = new int[100];
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                nums[i - 1] = i;
            }
        }
        return nums;
    }

    private static void arrayUp(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static void arrayDown(int[] arr) {
        System.out.println();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
