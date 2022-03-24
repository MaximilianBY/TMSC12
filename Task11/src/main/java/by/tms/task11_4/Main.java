package by.tms.task11_4;

public class Main {

  public static void main(String[] args) {
    double totalPrice = 0;
    Apricot apricot = new Apricot(1500, 4.99);
    Pear pear = new Pear(400, 3.89);
    Apple apple = new Apple(2000, 2.54);
    purchaseInfo(apple);
    purchaseInfo(apricot);
    purchaseInfo(pear);

    totalPrice = apricot.getToPay() + pear.getToPay() + apple.getToPay();
    System.out.println("Общая стоимость покупки составила " + totalPrice + " рублей");
  }

  public static void purchaseInfo(Fruit fruit) {
    System.out.println(
        "С Вас " + fruit.getToPay() + " рублей, за " + fruit.getWeight() + " грамм яблок");
  }
}
