package by.tms.utils;

import static by.tms.db_utils.CRUDProduct.getProductsFromDB;

import by.tms.model.Product;
import java.util.List;
import java.util.Map;

public final class ProductList {

  private static Map<Integer, Product> productListFromDB;

  private ProductList() {
    throw new java.lang.UnsupportedOperationException(
        "This is a utility class and cannot be instantiated");
  }

  private static void getAllProducts() {
    productListFromDB = getProductsFromDB();
  }

  public static List<Product> getProductListByCategory(int category) {
    getAllProducts();
    return productListFromDB.values().stream()
        .filter(product -> product.getCategoryID() == category).toList();
  }

  public static Product getProductByID(int id) {
    getAllProducts();
    return productListFromDB.get(id);
  }
}
