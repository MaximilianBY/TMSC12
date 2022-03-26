package by.tms.shop.service;

import by.tms.shop.exception.InputException;
import by.tms.shop.module.Product;
import by.tms.shop.module.ShopService;
import by.tms.shop.utils.Application;

public class Main {

  public static void main(String[] args) {
    ShopService shopService1 = new ShopService();
    Product pomidor = new Product(213, "Pomidor", 2647);
    Product ogurec = new Product(356, "Ogurec", 345);
    Product hleb = new Product(321, "Hleb", 45);
    Product voda = new Product(543, "Voda", 76978);
    try {
      shopService1.addProductToList(pomidor);
      shopService1.addProductToList(ogurec);
      shopService1.addProductToList(hleb);
      shopService1.addProductToList(voda);
    } catch (InputException e) {
      System.out.println(e.getMessage());
    }
    try {
      Application.start(shopService1);
    } catch (InputException e) {
      System.out.println(e.getMessage());
    } catch (NumberFormatException e) {
      System.out.println("Введено некорректное значение " + e.getMessage());
    }
  }
}
