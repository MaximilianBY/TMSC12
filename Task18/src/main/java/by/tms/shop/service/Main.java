package by.tms.shop.service;

import by.tms.shop.model.Buyer;
import by.tms.shop.model.Cashier;
import by.tms.shop.model.Shop;

public class Main {

  public static void main(String[] args) {
    Shop shop = new Shop();
    new Buyer(shop, 12).start();
    new Cashier(shop).start();
  }
}
