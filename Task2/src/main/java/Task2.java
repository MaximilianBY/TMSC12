public class Task2 {
    public static void main(String[] args) {
        //вывод на консоль
        printLiterals();
        //Некоторые тесты для проверки задач.
        System.out.println(sum(100, 200));
        System.out.println(sum(Integer.MAX_VALUE, Integer.MAX_VALUE));
        System.out.println(max(56, 349));
        System.out.println(calculateHypotenuse(3, 4));
    }

    private static void printLiterals() {
        boolean boolLit = true;
        System.out.println("True or False: " + boolLit + "\n");
        String str = "My name Maximilian";
        System.out.println("What is your name?" + "\n" + str + "\n");
        char chLit = 'M';
        System.out.println(chLit + "\n");
        int someNumInt = 156;
        System.out.println("in Binary system " + Integer.toBinaryString(someNumInt) + "\n");
        System.out.println("in Octal system " + Integer.toOctalString(someNumInt) + "\n");
        System.out.println("in Normal system " + someNumInt + "\n");
        System.out.println("in Hex system " + Integer.toHexString(someNumInt) + "\n");
        System.out.println(1.46568 + "\n");
        System.out.println(Math.random() + "\n");
//        вывести на консоль литералы следующих видов:
//        логический
//        строковый
//        символьный
//        целочисленный 2-й
//        целочисленный 8-й
//        целочисленный 10-й
//        целочисленный 16-й
//        литерал типа float
//        литерал типа double.
    }

    /**
     * 1. Метод должен вернуть сумму двух чисел a и b
     * 2. Дополнительно: сделать проверку если сумма a и b больше чем максимальное значение int то вернуть -1
     **/
    public static int sum(int a, int b) {
        int sum = a + b;
        if (sum > Integer.MAX_VALUE || a >= Integer.MAX_VALUE || b >= Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return sum;
        }
    }

    /**
     * Метод должен вернуть максимальное значение из двух чисел
     *
     * <p>
     * Example1:
     * a = 4,
     * b = 5
     * <p>
     * Метод должен вернуть 5
     * Example2:
     * a = 10,
     * b = 10
     * <p>
     * Метод должен вернуть 10
     */
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * Используя теорему Пифагора, вычислите значение гипотенузы. Квадрат гипотенузы = сумме квадратов катетов
     * <p>
     * Example1:
     * 3
     * 4
     * return 5
     * <p>
     * Example2:
     * 12
     * 16
     * return 20
     */
    public static double calculateHypotenuse(int a, int b) {
        int hypotenuse = a * a + b * b;
        return Math.round(Math.sqrt(hypotenuse));
    }
}
