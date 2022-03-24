/*        7) Проверить, различны ли все элементы массива, если не различны то вывести элемент повторяющийся
        Пример: {0,3,46,3,2,1,2}
        Массив имеет повторяющиеся элементы 3, 2
        Пример: {0,34,46,31,20,1,28}
        Массив не имеет повторяющихся элементов

 */

import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5_7 {

    public static void main(String[] args) {
        countDublicates(arrayInt());
    }

    private static List<Integer> arrayInt() {
        return Stream.generate(() -> new Random().nextInt(0, 10))
            .limit(10)
            .collect(Collectors.toList());
    }

    private static List<Integer> countDublicates(List<Integer> list) {
        list.forEach(num -> System.out.print(num + " "));
        return list.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .filter(i -> i.getValue() > 1)
            .map(Entry::getKey)
            .toList();
    }

    private static void printDublicates(List<Integer> list) {
        if (!list.isEmpty()) {
            System.out.print("Повторяющиеся элементы массива: ");
            list.stream().forEach(num -> System.out.print(num + " "));
        } else {
            System.out.println("Массив не имеет повторяющихся элементов");
        }
    }
}
