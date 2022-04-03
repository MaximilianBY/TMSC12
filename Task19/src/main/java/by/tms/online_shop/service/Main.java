package by.tms.online_shop.service;

import by.tms.online_shop.model.Product;
import by.tms.online_shop.utils.CRUDUtils;

public class Main {

  public static void main(String[] args) {
    System.out.println("View all products:");
    CRUDUtils.getAllProduct().forEach(System.out::println);

    System.out.println("Insert new product:");
    CRUDUtils.insertNewProduct(
            new Product("HONOR", "MagicBook X15", "Отличный вариант для работы и дома", 700, 10))
        .forEach(System.out::println);

    System.out.println("Update description:");
    CRUDUtils.updateProductDescription(2, "мощно стильно но не идеально", 50)
        .forEach(System.out::println);

    System.out.println("Delete unsaleable product");
    CRUDUtils.deleteProductFromDB(7).forEach(System.out::println);
  }
}
