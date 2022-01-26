//1) Задача на оператор switch!
//        Рандомно генерируется число От 1 до 7.
//        Если число равно 1, выводим на консоль “Понедельник”, 2 –”Вторник” и так далее.
//        Если 6 или 7 – “Выходной”.

//2) Одноклеточная амеба каждые 3 часа делится на 2 клетки. Определить,
//         сколько амеб будет через 3, 6, 9, 12,..., 24 часа

//3) В переменную записываем число.
//        Надо вывести на экран сколько в этом числе цифр и положительное оно или отрицательное.
//        Например, Введите число: 5
//        "5 - это положительное число, количество цифр = 1"
//4) Дано 2 числа, день и месяц рождения. Написать программу, которая определяет знак зодиака человека.

//Некоторые тесты для проверки задач. Можно также написать свои тесты.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        System.out.println(dayOfWeek(randomDayOfWeek())); //вывод задача 1
        System.out.println("Сколько Амеб получилось за сутки: " + countAmeba()); //вывод задача 2
        System.out.println(infoNum(randomNumber())); //вывод задача 3
        System.out.println("Ваш знак задиака: " + zodiacSign(readNumConsole())); //вывод задача 4
        System.out.println(Arrays.toString(arrayNum(readIntNum()))); //вывод задача 5
        System.out.println(operation()); //вывод задача 6
        System.out.println(calculateCountOfOddElementsInMatrix(arrayRandom())); //вывод задача 7
        System.out.println(calculateCountOfOddElementsInMatrix(new int[]{1, 2, 3, 4, 5, 6})); //вывод задача 7
        countDevs(103);
        countDevs(11);
        foobar(6); //вывод задача 9
        foobar(10); //вывод задача 9
        foobar(15); //вывод задача 9
        printPrimeNumbers();
    }

    private static int randomDayOfWeek() {
        int day = 1 + (int) (Math.random() * 7);
        return day;
    }

    private static String dayOfWeek(int day) {
        String dayOfWeek = null;
        switch (day) {
            case 1:
                dayOfWeek = "Monday";
                break;
            case 2:
                dayOfWeek = "Tuesday";
                break;
            case 3:
                dayOfWeek = "Wednesday";
                break;
            case 4:
                dayOfWeek = "Thursday";
                break;
            case 5:
                dayOfWeek = "Friday";
                break;
            case 6, 7:
                dayOfWeek = "Day off";
                break;
        }
        return dayOfWeek;
    }

    private static int countAmeba() {
        int countQuantity = 1;
        for (int i = 3; i <= 24; i += 3) {
            countQuantity += 2;
            System.out.println(countQuantity);
        }
        return countQuantity;
    }

    private static int randomNumber() {
        Random random = new Random();
        int number = random.nextInt();
        return number;
    }

    private static String infoNum(int someNum) {
        String number = String.valueOf(someNum);
        String polarity = null;
        if (someNum > 0) {
            polarity = "положительное";
        } else {
            polarity = "отрицательное";
        }
        int numLength = 0;
        if (number.contains("-")) {
            numLength = number.length() - 1;
        } else {
            numLength = number.length();
        }
        return "Число на проверке: " + someNum + ". Количество цифр в числе: " + numLength + ", число: " + polarity;
    }

    private static double readNumConsole() {
        System.out.print("Введите день и месяц рождения(в формате 20,03 или 4,05), " +
                "чтобы узнать свой знак зодиака: ");
        Scanner sc = new Scanner(System.in);
        double day = sc.nextDouble();
        return day;
    }

    private static String zodiacSign(double dateBirth) {
        if (dateBirth >= 21.03 && dateBirth <= 31.03 || dateBirth >= 1.04 && dateBirth <= 20.04) {
            return "Овен";
        } else if (dateBirth >= 21.04 && dateBirth <= 30.04 || dateBirth >= 1.05 && dateBirth <= 21.05) {
            return "Телец";
        } else if (dateBirth >= 22.05 && dateBirth <= 31.05 || dateBirth >= 1.06 && dateBirth <= 21.06) {
            return "Близнецы";
        } else if (dateBirth >= 22.06 && dateBirth <= 30.06 || dateBirth >= 1.07 && dateBirth <= 22.07) {
            return "Рак";
        } else if (dateBirth >= 23.07 && dateBirth <= 31.07 || dateBirth >= 1.08 && dateBirth <= 21.08) {
            return "Лев";
        } else if (dateBirth >= 22.08 && dateBirth <= 31.08 || dateBirth >= 1.09 && dateBirth <= 23.09) {
            return "Дева";
        } else if (dateBirth >= 24.09 && dateBirth <= 30.09 || dateBirth >= 1.10 && dateBirth <= 23.10) {
            return "Весы";
        } else if (dateBirth >= 24.10 && dateBirth <= 31.10 || dateBirth >= 1.11 && dateBirth <= 23.11) {
            return "Скорпион";
        } else if (dateBirth >= 23.11 && dateBirth <= 30.11 || dateBirth >= 1.12 && dateBirth <= 22.12) {
            return "Стрелец";
        } else if (dateBirth >= 23.12 && dateBirth <= 31.12 || dateBirth >= 1.01 && dateBirth <= 20.01) {
            return "Козерог";
        } else if (dateBirth >= 21.01 && dateBirth <= 31.01 || dateBirth >= 1.02 && dateBirth <= 19.02) {
            return "Водолей";
        } else if (dateBirth >= 20.02 && dateBirth <= 29.02 || dateBirth >= 1.03 && dateBirth <= 22.03) {
            return "Рыбы";
        }
        return "Вы ввели недопустимое значение, попробуйте заново";
    }

    /**
     * Необходимо прочитать с консоли значение числа типа int,
     * сделать проверку что если пользователь ввел не положительное число,
     * то вывести ошибку и отправить пользователя вводить заново новое число!
     * далее создать одномерный массив типа int размера прочитанного с консоли
     * далее заполнить массив случайными значениями
     * далее вывести массив на консоль
     */
    private static int readIntNum() {
        System.out.print("Введите положительное целое число: ");
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while (scanner.hasNextInt()) {
            num = scanner.nextInt();
            if (num > 0) {
                break;
            } else {
                System.out.println("Введено отрицательное число, повторите ввод");
            }
        }
        return num;
    }

    private static int[] arrayNum(int num) {
        int[] arrayRandom = new int[num];
        Random random = new Random();
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = random.nextInt();
        }
        return arrayRandom;
    }

    /**
     * Метод должен выполнять некоторую операцию с int "number" в зависимости от некоторых условий:
     * - if number положительное число, то необходимо number увеличить на 1
     * - if number отрицательное - уменьшить на 2
     * - if number равно 0 , то замените значение number на 10
     * вернуть number после выполнения операций
     */
    public static int operation() {
        System.out.print("Введите целое число: ");
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while (scanner.hasNextInt()) {
            num = scanner.nextInt();
            if (num > 0) {
                num++;
                break;
            } else if (num < 0) {
                num -= 2;
                break;
            } else {
                num = 10;
                break;
            }
        }
        return num;
    }

    /**
     * На вход приходит массив целых чисел типа int
     * Необходимо найти количество нечетных элементов в массиве и вернуть значение в метод main,
     * в котором это значение распечатается на консоль.
     */
    private static int[] arrayRandom() {
        int[] arrayRandom = new int[6];
        Random random = new Random();
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = random.nextInt();
        }
        return arrayRandom;
    }

    public static int calculateCountOfOddElementsInMatrix(int[] ints) {
        System.out.print(Arrays.toString(ints)); //для проверки
        int count = 0;
        for (Integer value : ints) {
            if (value % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * На вход приходит число.
     * Вывести в консоль фразу из разряда "_COUNT_ программистов",
     * заменить _COUNT_ на число которое пришло на вход в метод и заменить окончание в слове "программистов" на
     * уместное с точки зрения русского языка.
     * Пример: 1 программист, 42 программиста, 50 программистов
     *
     * @param count - количество программистов
     */
    public static void countDevs(int count) {
        int num = 0;
        if (count == 1 || count == 101) {
            num = 1;
        } else if (count >= 2 && count <= 4 || count >= 102 && count <= 104) {
            num = 2;
        } else {
            num = 3;
        }
        switch (num) {
            case 1:
                System.out.println(count + " программист");
                break;
            case 2:
                System.out.println(count + " программиста");
                break;
            case 3:
                System.out.println(count + " программистов");
                break;
        }
    }

    /**
     * Метод должен выводить разные строки в консоли в зависимости от некоторых условий:
     * - если остаток от деления на 3 равен нулю - выведите "foo" (example of number - 6)
     * - если остаток от деления на 5 равен нулю - вывести "bar" (example of number - 10)
     * - если остаток от деления на 3 и 5 равен нулю 0 ,то вывести "foobar" (example of number - 15)
     */
    public static void foobar(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("foobar");
        } else if (number % 3 == 0) {
            System.out.println("foo");
        } else if (number % 5 == 0) {
            System.out.println("bar");
        }
    }

    /**
     * Задача со звездочкой!
     * Метод должен печатать все простые числа <1000
     * что такое просто число (https://www.webmath.ru/poleznoe/formules_18_5.php)
     */
    public static void printPrimeNumbers() {
        for (int i = 2; i <= 1000; i++) {

            for (int j = 2; j <= i; j++) {

                if (j < i && i % j == 0) {
                    break;
                }
                if (i % j == 0) {
                    System.out.println(i);
                }
            }
        }
    }
}
