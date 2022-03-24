import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Scanner;

public class Task3 {

  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
//    printABC();
//    System.out.println("Следующее задание:");
    printNum();
    System.out.println("Следующее задание:");
    printNumABS();
    System.out.println("Следующее задание:");
//    printTime();
//    System.out.println("Следующее задание:");
//    tableOfType();
//    System.out.println("Следующее задание:");
//    int[] arrayOfNums = {1, 5, 7, 4, 7, 9, 20, 3};
//    System.out.println(average(arrayOfNums));
//    max(arrayOfNums);
  }

  private static void printABC() {
    System.out.println("Выводим алфавит:");
    for (char i = 'A'; i <= 'Z'; i++) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static void printNum() {
    System.out.println("Введите целое число");
    while (true) {
      if (sc.hasNextInt()) {
        int inputNum = sc.nextInt();
        System.out.println(
            inputNum % 2 == 0 ? inputNum + "Число чётное" : inputNum + "Число нечётное");
      } else {
        return;
      }
    }
  }

  private static int readValueFromConsole() {
    if (sc.hasNextInt()) {
      return sc.nextInt();
    }
    return 0;
  }

  private static int findMinValue(int first, int second) {
    return Math.abs(Math.min(first, second));
  }

  private static void printNumABS() {
    System.out.println("Введите 3 целых числа:");
    int a = readValueFromConsole();
    int b = readValueFromConsole();
    int c = readValueFromConsole();
    System.out.println(findMinValue(findMinValue(a, b), c));
  }

  private static void printTime() {
    int millisWorkTime = 28800, remainingTime;
    int millisInHour = 60 * 60; //тут я вычислил сколько в одном часе секунд = 3600с
    Random randomRemainTime = new Random();
    remainingTime = randomRemainTime.nextInt(millisWorkTime + 1) / millisInHour;
    System.out.println(remainingTime);
    switch (remainingTime) {
      case 0:
        System.out.println("рабочий день окончен");
        break;
      case 1:
        System.out.println("осталось менее часа");
        break;
      case 2, 3, 4, 5, 6, 7, 8:
        System.out.println("осталось " + remainingTime + " часа");
        break;
    }
  }

  private static void tableOfType() {
    System.out.printf("%12s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "byte", "short", "char", "int",
        "long",
        "float", "double", "boolean");
    System.out.printf("%s%8s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "byte", "x", "ня", "tя", "ня", "ня",
        "ня", "ня", "х");
    System.out.printf("%s%7s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "short", "x", "ня", "tя", "ня",
        "ня",
        "ня", "ня", "х");
    System.out.printf("%s%8s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "char", "x", "ня", "tя", "ня", "ня",
        "ня", "ня", "х");
    System.out.printf("%s%9s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "int", "x", "ня", "tя", "ня", "ня",
        "ня", "ня", "х");
    System.out.printf("%s%8s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "long", "x", "ня", "tя", "ня", "ня",
        "ня", "ня", "х");
    System.out.printf("%s%7s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "float", "x", "ня", "tя", "ня",
        "ня",
        "ня", "ня", "х");
    System.out.printf("%s%6s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "double", "x", "ня", "tя", "ня",
        "ня",
        "ня", "ня", "х");
    System.out.printf("%s%5s|%6s|%5s|%4s|%5s|%6s|%7s|%8s|%n", "boolean", "x", "ня", "tя", "ня",
        "ня", "ня", "ня", "х");
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
   * 6) Метод должен вернуть среднее значение из массива чисел (необходимо сумму всех элеменов
   * массива разделить на длину массива)
   * <p>
   * Example: array = {1,2,3,4,5} Метод должен return 3.0
   */
  public static double average(int[] array) {
    OptionalDouble arrAverage = Arrays.stream(array).average();
    if (arrAverage.isPresent()) {
      return arrAverage.getAsDouble();
    }
    return 0;
  }

  /**
   * 7) Метод должен вернуть максимальый элемент массива. Пример: array = {1,2,10,3} метод
   * возвращает 10
   **/
  public static int max(int[] array) {
    OptionalInt maxValue = Arrays.stream(array).max();
    if (maxValue.isPresent()) {
      return maxValue.getAsInt();
    }
    return 0;
  }
}
