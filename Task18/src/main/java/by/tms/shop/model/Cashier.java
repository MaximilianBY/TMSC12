package by.tms.shop.model;

public class Cashier extends Thread {

  public static final int quantity = 6;
  private final Shop shop;

  public Cashier(Shop shop) {
    this.shop = shop;
  }

  @Override
  public void run() {
    try {
      while (Buyer.getQuantity() > 0) {
        shop.endService();
        Thread.sleep(100);
      }
    } catch (InterruptedException e) {
      System.out.println("interrupt");
    }
  }
}
