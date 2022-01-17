import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Через консоль вводятся данные, необходимо посчитать кол-во целых положительных чисел и вывести результат на консоль,
если введено не целое число, то программа должна запросить повторный ввод или ввод окончания работы программы.

1. Ввод данных оформить отдельным методом и с проверкой вводимых данных.
2. Подсчет организовать в отдельном методе.
3. Вывести на консоль конечный результат пункта 2.
 */
public class Task1 {
    static int count;
    static List<Integer> nums = new ArrayList<Integer>();
    public static void main(String[] args) {
        System.out.println("Введите целое число, для окончания введите end:");
        inReader();
        getCount();
        for (Integer value:nums) {
            System.out.println(value);
        }
        System.out.println("Кол-во введенных целых положительных чисел: "+ count);
    }
    public static void inReader() {
        Scanner inStr = new Scanner(System.in);
        while (inStr.hasNext()) {
            if (inStr.hasNextInt()) {
                nums.add(inStr.nextInt());
            } else if (inStr.next().equals("end")) {
                break;
            } else {
                System.out.println("Введено неккорректное значение, введите еще раз или окончите ввод:");
            }
        }
    }
    private static void getCount(){
        count = 0;
        for (Integer value:nums) {
            if (value > 0){
                count++;
            }
        }
    }
}
