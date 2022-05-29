package by.tms.db_utils;

import static by.tms.db_utils.CRUDUser.getConnection;

import by.tms.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public final class CRUDProduct {

  private static final String GET_ALL_PRODUCT =
      "SELECT * FROM eshop.product JOIN eshop.images scd_img ON product.id = scd_img.product_id";
  private static final String UPDATE_QUANTITY_PRODUCT = "UPDATE eshop.product SET quantity = quantity - ? WHERE id = ?";

  private static Connection connection = getConnection();

  private CRUDProduct() {
    throw new java.lang.UnsupportedOperationException(
        "This is a utility class and cannot be instantiated");
  }

  public static Map<Integer, Product> getProductsFromDB() {
    Map<Integer, Product> products = new HashMap<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCT);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id");
        String brand = rs.getString("brand");
        String model = rs.getString("model");
        String description = rs.getString("description");
        int price = rs.getInt("price");
        String imageName = rs.getString("image_path");
        int quantity = rs.getInt("quantity");
        int category = rs.getInt("category_id");
        if (quantity > 0) {
          products.put(id,
              new Product(id, brand, model, description, price, imageName, quantity, category));
        }
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return products;
  }

  public static void updateQuantityProducts(Product product) {
    try {
      PreparedStatement updateProduct = connection.prepareStatement(UPDATE_QUANTITY_PRODUCT);

      updateProduct.setInt(1, product.getQuantity());
      updateProduct.setInt(2, product.getId());

      updateProduct.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
