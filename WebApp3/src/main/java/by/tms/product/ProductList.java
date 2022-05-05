package by.tms.product;

import static by.tms.db_utils.CRUDProduct.getProductsFromDB;

import java.util.List;
import java.util.Optional;

public final class ProductList {

  private static List<Product> productListFromDB;

  private ProductList() {
    throw new java.lang.UnsupportedOperationException(
        "This is a utility class and cannot be instantiated");
  }

  public static List<Product> getProductListByType(String type) {
    return productListFromDB.stream()
        .filter(product -> product.getType().equals(type)).toList();
  }

  public static Product getProductByID(int id) {
    return productListFromDB.stream()
        .filter(product1 -> product1.getId() == id).findAny()
        .orElse(null);
  }

  public static void addProductsListFromDB() {
    List<Product> productList = getProductsFromDB();
    if (Optional.ofNullable(productList).isPresent()) {
      productListFromDB = productList;
    }
  }
}
