package by.tms.db_utils;

import static by.tms.db_utils.CRUDUser.getConnection;

import by.tms.model.Product;
import by.tms.utils.ProductList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CRUDCart {

  private static Connection connection = getConnection();

  private static final String GET_USER_CART =
      "SELECT * FROM eshop.orders JOIN eshop.order_product op "
          + "ON orders.id = op.order_id WHERE user_id=?";
  private static final String ADD_NEW_ORDER = "INSERT INTO eshop.orders(order_price, user_id) VALUE (?, ?)";
  private static final String ADD_PRODUCT_NEW_ORDER = "INSERT INTO eshop.order_product(product_id, product_quantity, order_id) VALUE (?, ?, LAST_INSERT_ID())";

  private CRUDCart() {
    throw new java.lang.UnsupportedOperationException(
        "This is a utility class and cannot be instantiated");
  }

  public static Map<Integer, Product> getUserCart(int userID) {
    Map<Integer, Product> userCart = new HashMap<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_CART);

      preparedStatement.setInt(1, userID);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int productID = rs.getInt("product_id");
        Product product = ProductList.getProductByID(productID);
        product.setPrice(rs.getInt("order_price"));
        product.setQuantity(rs.getInt("product_quantity"));
        userCart.put(rs.getInt("id"), product);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return userCart;
  }

  public static void updateOrder(int userID, Product product) {
    try {
      PreparedStatement order = connection.prepareStatement(ADD_NEW_ORDER);
      PreparedStatement productOrder = connection.prepareStatement(ADD_PRODUCT_NEW_ORDER);

      order.setInt(1, product.getPrice());
      order.setInt(2, userID);

      productOrder.setInt(1, product.getId());
      productOrder.setInt(2, product.getQuantity());

      order.executeUpdate();
      productOrder.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
