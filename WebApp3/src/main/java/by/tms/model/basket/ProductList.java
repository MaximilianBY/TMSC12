package by.tms.model.basket;

import static by.tms.db_utils.CRUDProduct.getProductsFromDB;

import by.tms.model.product.Product;
import java.util.List;
import java.util.Optional;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class ProductList {

  private static List<Product> productListFromDB;

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
