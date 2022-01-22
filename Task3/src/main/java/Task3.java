import java.util.Scanner;

public class Task3 {

    private static void printABC() {
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.print(i + " ");
        }
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

    private static void printNumABS() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число или end для завершения:");
        while (sc.hasNext()) {
            int a = 0, b = 0, c = 0;
            if (sc.hasNextInt()) {
                a = sc.nextInt();
            } else if (sc.next().equals("end")) {
                break;
            }
            if (sc.hasNextInt()) {
                b = sc.nextInt();
            } else if (sc.next().equals("end")) {
                break;
            }
            if (sc.hasNextInt()) {
                c = sc.nextInt();
            } else if (sc.next().equals("end")) {
                break;
            }
            if (Math.abs(Math.min(a, b)) == Math.abs(Math.min(a, c))) {
                System.out.println("Минимальное число: " + a);
            } else if (Math.abs(Math.min(a, b)) == Math.abs(Math.min(b, c))) {
                System.out.println("Минимальное число: " + b);
            } else {
                System.out.println("Минимальное число: " + c);
            }
        }
    }

    private static void printTime() {
        int millisWorkTime = 28800, millisInHour = millisWorkTime / 8, remainingTime;
        int randomRemainTime = (int) (Math.random() * millisWorkTime);
        remainingTime = Math.round(randomRemainTime / millisInHour);
        if (remainingTime >= 5) {
            System.out.println("В " + randomRemainTime + " секундах " + remainingTime + " часов" + "\n");
            System.out.println("осталось " + remainingTime + " часов");
        } else if (remainingTime >= 2) {
            System.out.println("В " + randomRemainTime + " секундах " + remainingTime + " часа" + "\n");
            System.out.println("осталось " + remainingTime + " часа");
        } else if (remainingTime > 0) {
            System.out.println("В " + randomRemainTime + " секундах " + remainingTime + " менее часа" + "\n");
            System.out.println("осталось менее часа");
        } else {
            System.out.println("В " + randomRemainTime + " секундах " + remainingTime + " часов" + "\n");
            System.out.println("рабочий день окончен");
        }
    }

    private static void tableOfType() {
        System.out.println("Первый вариант через print:");
        System.out.print("\t\t|\tbyte\t|\tshort\t|\tchar\t|\tint\t|\tlong\t|\tfloat\t|\tdouble\t|\tboolean\n");
        System.out.print("byte\t|\tx\t\t|\tня\t\t|\tя\t\t|\tня\t|\tня\t\t|\tня\t\t|\tня\t\t|\tх\n");
        System.out.print("short\t|\tя\t\t|\tх\t\t|\tя\t\t|\tня\t|\tня\t\t|\tня\t\t|\tня\t\t|\tx\n");
        System.out.print("char\t|\tя\t\t|\tя\t\t|\tх\t\t|\tня\t|\tня\t\t|\tня\t\t|\tня\t\t|\tx\n");
        System.out.print("int\t\t|\tя\t\t|\tя\t\t|\tя\t\t|\tх\t|\tня\t\t|\tня\t\t|\tня\t\t|\tx\n");
        System.out.print("long\t|\tя\t\t|\tя\t\t|\tя\t\t|\tя\t|\tх\t\t|\tня\t\t|\tня\t\t|\tx\n");
        System.out.print("float\t|\tя\t\t|\tя\t\t|\tя\t\t|\tя\t|\tя\t\t|\tх\t\t|\tня\t\t|\tx\n");
        System.out.print("double\t|\tя\t\t|\tя\t\t|\tя\t\t|\tя\t|\tя\t\t|\tя\t\t|\tх\t\t|\tx\n");
        System.out.print("boolean\t|\tх\t\t|\tх\t\t|\tх\t\t|\tх\t|\tх\t\t|\tх\t\t|\tх\t\t|\tx\n");
        System.out.println();
        System.out.println("Второй вариант через println:");
        System.out.println("\t\t|\tbyte\t|\tshort\t|\tchar\t|\tint\t|\tlong\t|\tfloat\t|\tdouble\t|\tboolean");
        System.out.println("byte\t|\tx\t\t|\tня\t\t|\tя\t\t|\tня\t|\tня\t\t|\tня\t\t|\tня\t\t|\tх");
        System.out.println("short\t|\tя\t\t|\tх\t\t|\tя\t\t|\tня\t|\tня\t\t|\tня\t\t|\tня\t\t|\tx");
        System.out.println("char\t|\tя\t\t|\tя\t\t|\tх\t\t|\tня\t|\tня\t\t|\tня\t\t|\tня\t\t|\tx");
        System.out.println("int\t\t|\tя\t\t|\tя\t\t|\tя\t\t|\tх\t|\tня\t\t|\tня\t\t|\tня\t\t|\tx");
        System.out.println("long\t|\tя\t\t|\tя\t\t|\tя\t\t|\tя\t|\tх\t\t|\tня\t\t|\tня\t\t|\tx");
        System.out.println("float\t|\tя\t\t|\tя\t\t|\tя\t\t|\tя\t|\tя\t\t|\tх\t\t|\tня\t\t|\tx");
        System.out.println("double\t|\tя\t\t|\tя\t\t|\tя\t\t|\tя\t|\tя\t\t|\tя\t\t|\tх\t\t|\tx");
        System.out.println("boolean\t|\tх\t\t|\tх\t\t|\tх\t\t|\tх\t|\tх\t\t|\tх\t\t|\tх\t\t|\tx");
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
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;

                    buf = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;
                }
            }
        }
        return array[array.length - 1];
    }

    public static void main(String[] args) {
        printABC();
        printNum();
        printNumABS();
        printTime();
        tableOfType();
        int[] arrayOfNums = {1, 5, 7, 4, 7, 9, 20, 3};
        System.out.println(average(arrayOfNums));
        System.out.println(max(arrayOfNums));
    }
}
