import java.util.Arrays;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        printABC();
        System.out.println("Следующее задание:");
        printNum();
        System.out.println("Следующее задание:");
        printNumABS();
        System.out.println("Следующее задание:");
        printTime();
        System.out.println("Следующее задание:");
        tableOfType();
        System.out.println("Следующее задание:");
        int[] arrayOfNums = {1, 5, 7, 4, 7, 9, 20, 3};
        System.out.println(average(arrayOfNums));
        System.out.println(max(arrayOfNums));
    }

    private static void printABC() {
        System.out.println("Выводим алфавит:");
        for (char i = 'A'; i <= 'Z'; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число или end для завершения:");
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                if (sc.nextInt() % 2 == 0) {
                    System.out.println("Число чётное");
                } else {
                    System.out.println("Число нечётное");
                }
            } else if (sc.next().equals("end")) {
                break;
            } else {
                System.out.println("Введено неккорректное значение, введите еще раз или окончите ввод:");
            }
        }
    }

    private static int readValueFromConsole(Scanner sc) {
        int someNum = 0;
        if (sc.hasNextInt()) {
            someNum = sc.nextInt();
        }
        return someNum;
    }

    private static int findMinValue(int first, int second) {
        return Math.min(Math.abs(first), Math.abs(second));
    }

    private static void printNumABS() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 3 целых числа:");
        int a = readValueFromConsole(sc);
        int b = readValueFromConsole(sc);
        int c = readValueFromConsole(sc);
        System.out.println(findMinValue(findMinValue(a, b), c));
    }

    private static void printTime() {
        int millisWorkTime = 28800, remainingTime;
        int millisInHour = millisWorkTime / 8; //тут я вычислил сколько в одном часе секунд = 3600с
        int randomRemainTime = (int) Math.round(Math.random() * (millisWorkTime + 1));
        remainingTime = Math.round(randomRemainTime / millisInHour);//а тут я просто рандомное число делил на 3600 и получал часы
        if (remainingTime >= 5) {
            System.out.println("В " + randomRemainTime + " секундах " + remainingTime + " часов" + "\n");
            System.out.println("осталось " + remainingTime + " часов");
        } else if (remainingTime >= 2) {
            System.out.println("В " + randomRemainTime + " секундах " + remainingTime + " часа" + "\n");
            System.out.println("осталось " + remainingTime + " часа");
        } else if (remainingTime > 0) {
            System.out.println("В " + randomRemainTime + " секундах " + remainingTime + " час" + "\n");
            System.out.println("осталось менее часа");
        } else {
            System.out.println("В " + randomRemainTime + " секундах " + remainingTime + " часов" + "\n");
            System.out.println("рабочий день окончен");
        }
    }

    private static void tableOfType() {
        System.out.printf("%12s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "byte", "short", "char", "int", "long", "float", "double", "boolean");
        System.out.printf("%s%8s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "byte", "x", "ня", "tя", "ня", "ня", "ня", "ня", "х");
        System.out.printf("%s%7s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "short", "x", "ня", "tя", "ня", "ня", "ня", "ня", "х");
        System.out.printf("%s%8s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "char", "x", "ня", "tя", "ня", "ня", "ня", "ня", "х");
        System.out.printf("%s%9s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "int", "x", "ня", "tя", "ня", "ня", "ня", "ня", "х");
        System.out.printf("%s%8s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "long", "x", "ня", "tя", "ня", "ня", "ня", "ня", "х");
        System.out.printf("%s%7s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "float", "x", "ня", "tя", "ня", "ня", "ня", "ня", "х");
        System.out.printf("%s%6s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "double", "x", "ня", "tя", "ня", "ня", "ня", "ня", "х");
        System.out.printf("%s%5s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "boolean", "x", "ня", "tя", "ня", "ня", "ня", "ня", "х");
    }
    //Задачи:
    //1) Используя тип данных char и операцию инкремента вывести на консоль все буквы английского алфавита

    //2)Проверка четности числа
    //Создать программу, которая будет сообщать, является ли целое число, введённое пользователем,
    // чётным или нет. Ввод числа осуществлять с помощью класса Scanner.
    // Если пользователь введёт не целое число, то сообщать ему об ошибке.

    //3) Меньшее по модулю число
    //Создать программу, которая будет выводить на экран меньшее по модулю из трёх введённых
    // пользователем вещественных чисел с консоли.

    //4) На некотором предприятии инженер Петров создал устройство, на табло которого показывается количество секунд,
    // оставшихся до конца рабочего дня. Когда рабочий день начинается ровно в 9 часов утра — табло отображает «28800» (т.е. остаётся 8 часов),
    // когда времени 14:30 — на табло «9000» (т.е. остаётся два с половиной часа), а когда наступает 17 часов — на табло отображается «0»
    // (т.е. рабочий день закончился).
    //Программист Иванов заметил, как страдают офисные сотрудницы — им неудобно оценивать остаток рабочего дня в секундах.
    // Иванов вызвался помочь сотрудницам и написать программу, которая вместо секунд будет выводить на табло понятные фразы с информацией о том,
    // сколько полных часов осталось до конца рабочего дня. Например: «осталось 7 часов», «осталось 4 часа», «остался 1 час», «осталось менее часа».
    //Итак, в переменную n должно записываться случайное (на время тестирования программы) целое число из [0;28800],
    // далее оно должно выводиться на экран (для Петрова) и на следующей строке (для сотрудниц) должна
    // выводиться фраза о количестве полных часов, содержащихся в n секундах.

    //5) Необходимо написать программу, которая будет выводить на консоль таблицу приведения типов!
//              byte	short	char	int 	long	float	double	boolean
//    byte
//    short
//    char
//    int
//    long
//    float
//    double
//    boolean
//
//    На пересечении напишите следующие фразы:
//    ня (неявное) – если преобразование происходит автоматически,
//    я (явное) – если нужно использовать явное преобразование,
//    х – если преобразование невозможно,
//    т  - если преобразование тождественно.
//    Внимание! используйте System.out.printLn

    /**
     * 6) Метод должен вернуть среднее значение из массива чисел
     * (необходимо сумму всех элеменов массива разделить на длину массива)
     * <p>
     * Example:
     * array = {1,2,3,4,5}
     * Метод должен return 3.0
     */
    public static double average(int[] array) {
        double sumEl = 0;
        for (int j : array) {
            sumEl = sumEl + j;
        }
        return sumEl / array.length;
    }

    /**
     * 7) Метод должен вернуть максимальый элемент массива. Пример: array = {1,2,10,3} метод возвращает 10
     **/
    public static int max(int[] array) {
        Arrays.sort(array);
        return array[array.length - 1];
    }
}
