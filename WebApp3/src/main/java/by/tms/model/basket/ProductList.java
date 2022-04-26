package by.tms.model.basket;

import by.tms.model.product.Product;
import java.util.List;

public final class ProductList {

  private static List<Product> productListFromDB;

  public static List<Product> getProductListFromDB() {
    return productListFromDB;
  }

  public static void addProductToListFromDB(List<Product> list) {
    productListFromDB = list;
  }
}
