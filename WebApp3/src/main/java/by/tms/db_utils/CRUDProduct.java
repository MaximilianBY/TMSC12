package by.tms.db_utils;

import static by.tms.db_utils.CRUDUser.getConnection;

import by.tms.model.product.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class CRUDProduct {

  private static final String GET_ALL_PRODUCT =
      "SELECT * FROM online_shop_product.product_db JOIN online_shop_product.product_image_db scd on product_db.id = scd.id ";
  private static final String UPDATE_QUANTITY_PRODUCT = "UPDATE online_shop_product.product_db SET quantity = quantity - 1 WHERE description = ?";

  private static Connection connection = getConnection();

  public static List<Product> getProductsFromDB() {
    List<Product> products = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCT);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id");
        String brand = rs.getString("brand");
        String model = rs.getString("model");
        String type = rs.getString("type");
        String description = rs.getString("description");
        int price = rs.getInt("price");
        String imageName = rs.getString("name_image");
        int quantity = rs.getInt("quantity");
        if (quantity > 0) {
          products.add(
              new Product(id, brand, model, type, description, price, imageName, quantity));
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

      updateProduct.setString(1, product.getDescription());

      updateProduct.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
