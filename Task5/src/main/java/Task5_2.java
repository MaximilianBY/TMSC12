/*        2) Дан двухмерный массив размерностью 4 на 4, необходимо нарисовать четыре треугольника вида

        a)                  b)
              *        *
            * *        * *
          * * *        * * *
        * * * *        * * * *

        c)                  d)
        * * * *        * * * *
          * * *        * * *
            * *        * *
              *        *

 */

public class Task5_2 {
    public static void main(String[] args) {
        arrayStarsA();
        System.out.println();
        arrayStarsB();
        System.out.println();
        arrayStarsC();
        System.out.println();
        arrayStarsD();
    }

    private static void arrayStarsA() {
        String[][] arrayStar = new String[4][4];
        for (int i = 0; i < arrayStar.length; i++) {
            for (int j = arrayStar.length - 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void arrayStarsB() {
        String[][] arrayStar = new String[4][4];
        for (int i = 0; i < arrayStar.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void arrayStarsC() {
        String[][] arrayStar = new String[4][4];
        for (int i = arrayStar.length - 1; i >= 0; i--) {
            for (int j = arrayStar.length - 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void arrayStarsD() {
        String[][] arrayStar = new String[4][4];
        for (int i = arrayStar.length - 1; i >= 0; i--) {
            for (int j = 0; j < arrayStar.length; j++) {
                if (j <= i) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
