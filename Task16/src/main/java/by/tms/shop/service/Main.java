package by.tms.shop.service;

import by.tms.shop.module.Product;
import by.tms.shop.module.Shop;
import by.tms.shop.utils.Application;
import by.tms.shop.utils.Malfunction;

public class Main {

  public static void main(String[] args) {
    Shop shop1 = new Shop();
    Product pomidor = new Product(213, "Pomidor", 2647);
    Product ogurec = new Product(356, "Ogurec", 345);
    Product hleb = new Product(321, "Hleb", 45);
    Product voda = new Product(543, "Voda", 76978);
    try {
      shop1.addProductToList(pomidor);
      shop1.addProductToList(ogurec);
      shop1.addProductToList(hleb);
      shop1.addProductToList(voda);
    } catch (Malfunction e) {
      System.out.println(e.getMessage());
    }
    try {
      Application.start(shop1);
    } catch (Malfunction e) {
      System.out.println(e.getMessage());
    } catch (NumberFormatException e) {
      System.out.println("Введено некорректное значение " + e.getMessage());
    }
  }
}
