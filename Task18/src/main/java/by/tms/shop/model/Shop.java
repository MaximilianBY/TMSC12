package by.tms.shop.model;

import static by.tms.shop.model.Cashier.quantity;

public class Shop {

  private int counterOfAvailableCashier = quantity;

  synchronized int beingServed() {
    if (counterOfAvailableCashier > 0) {
      counterOfAvailableCashier--;
      System.out.println(
          "Свободных касс " + counterOfAvailableCashier + ", проходите!");
      return 1;
    }
    return 0;
  }

  synchronized void endService() {
    if (counterOfAvailableCashier < 4) {
      counterOfAvailableCashier++;
      System.out.println("Спасибо за покупку, приходите еще! Свободная касса!");
    }
  }

  public int getCounterOfAvailableCashier() {
    return counterOfAvailableCashier;
  }
}
