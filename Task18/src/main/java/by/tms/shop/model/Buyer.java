package by.tms.shop.model;

public class Buyer extends Thread {

  private final Shop shop;
  private static int quantity;

  public Buyer(Shop shop, int quantity) {
    this.shop = shop;
    this.quantity = quantity;
  }

  @Override
  public void run() {
    try {
      while (shop.getCounterOfAvailableCashier() > 0) {
        quantity -= shop.beingServed();
        System.out.println("Товары: батон, молоко, колбаса, макароны, масло, пиво");
        Thread.sleep(100);
      }
    } catch (InterruptedException e) {
      System.out.println("interrupt");
    }
  }

  public static int getQuantity() {
    return quantity;
  }
}
