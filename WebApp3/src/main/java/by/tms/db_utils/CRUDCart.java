package by.tms.db_utils;

import static by.tms.db_utils.CRUDUser.getConnection;

import by.tms.model.product.Product;
import by.tms.model.user.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CRUDCart {

  private static Connection connection = getConnection();

  private static final String ADD_PRODUCT_TO_CART =
      "INSERT INTO online_shop_users.users_purchases(user_id, order_id, brand, model, type, description, price, quantity, image_name, status_order)"
          + "value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

  private static final String GET_USER_CART = "SELECT * FROM online_shop_users.users_purchases WHERE status_order = 0";

  private static final String DELETE_ALL_PRODUCTS_FROM_CART =
      "DELETE FROM online_shop_users.users_purchases WHERE user_id = ? AND order_id = 0 "
          + "AND status_order = 0";
  private static final String DELETE_SOME_PRODUCT_FROM_CART =
      "DELETE FROM online_shop_users.users_purchases WHERE user_id = ? AND id = ? AND order_id = 0 "
          + "AND status_order = 0";

  private static final String GET_LAST_ORDER_ID = "SELECT * FROM online_shop_users.users_purchases WHERE order_id is not null";

  private static final String UPDATE_USER_ORDER =
      "UPDATE online_shop_users.users_purchases SET status_order = 1, order_id = ? "
          + "WHERE user_id = ? AND id = ? AND model = ? AND description = ?";

  private CRUDCart() {
    throw new java.lang.UnsupportedOperationException(
        "This is a utility class and cannot be instantiated");
  }

  public static void addProductToDBCart(User user,
      Product product, int numOrder, int statusOrder) {
    try {
      PreparedStatement addProduct = connection.prepareStatement(ADD_PRODUCT_TO_CART);

      addProduct.setString(1, user.getName());
      addProduct.setInt(2, numOrder);
      addProduct.setString(3, product.getBrand());
      addProduct.setString(4, product.getModel());
      addProduct.setString(5, product.getType());
      addProduct.setString(6, product.getDescription());
      addProduct.setInt(7, product.getPrice());
      addProduct.setInt(8, 1);
      addProduct.setString(9, product.getImageName());
      addProduct.setInt(10, statusOrder);

      addProduct.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static Map<Integer, Product> getUserCart(User user) {
    Map<Integer, Product> userCart = new HashMap<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_CART);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        if (rs.getString("user_id").equals(user.getName())) {
          int id = rs.getInt("id");
          int order_id = rs.getInt("order_id");
          String brand = rs.getString("brand");
          String model = rs.getString("model");
          String type = rs.getString("type");
          String description = rs.getString("description");
          int price = rs.getInt("price");
          int quantity = rs.getInt("quantity");
          String imageName = rs.getString("image_name");
          Product product = new Product(id, order_id, brand, model, type, description, price,
              quantity, imageName);
          userCart.put(id, product);
        }
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return userCart;
  }

  public static void delAllUnnecessaryProducts(User user, int id) {
    try {
      PreparedStatement delAllProducts = connection.prepareStatement(DELETE_ALL_PRODUCTS_FROM_CART);
      PreparedStatement delSomeProduct = connection.prepareStatement(DELETE_SOME_PRODUCT_FROM_CART);

      if (id != 0) {
        delSomeProduct.setString(1, user.getName());
        delSomeProduct.setInt(2, id);

        delSomeProduct.executeUpdate();
      } else {
        delAllProducts.setString(1, user.getName());

        delAllProducts.executeUpdate();
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static int getLastOrderID() {
    List<Integer> allOrderID = new ArrayList<>();
    try {
      PreparedStatement getOrderID = connection.prepareStatement(GET_LAST_ORDER_ID);
      ResultSet rs = getOrderID.executeQuery();

      while (rs.next()) {
        allOrderID.add(rs.getInt("order_id"));
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    int orderID = Optional.of(allOrderID).isEmpty() ? 0 : Collections.max(allOrderID);
    return orderID;
  }

  public static void updateOrder(User user, Product product, int order_id) {
    try {
      PreparedStatement updateProduct = connection.prepareStatement(UPDATE_USER_ORDER);

      updateProduct.setInt(1, order_id);
      updateProduct.setString(2, user.getName());
      updateProduct.setInt(3, product.getId());
      updateProduct.setString(4, product.getModel());
      updateProduct.setString(5, product.getDescription());

      updateProduct.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
