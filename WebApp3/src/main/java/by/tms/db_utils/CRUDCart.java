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
import java.util.List;
import java.util.Optional;

public class CRUDCart {

  private static Connection connection = getConnection();

  private static final String ADD_PRODUCT_TO_CART =
      "INSERT INTO online_shop_users.users_purchases(user_id, purchase_id, brand, model, type, description, price, image_name, status_order)"
          + "value (?, ?, ?, ?, ?, ?, ?, ?, ?)";

  private static final String GET_USER_CART = "SELECT * FROM online_shop_users.users_purchases WHERE status_order = 0";

  private static final String DELETE_ALL_PRODUCTS_FROM_CART =
      "DELETE FROM online_shop_users.users_purchases WHERE user_id=? AND purchase_id = 0 "
          + "AND status_order = 0";
  private static final String DELETE_SOME_PRODUCT_FROM_CART =
      "DELETE FROM online_shop_users.users_purchases WHERE user_id = ? AND id = ? AND purchase_id = 0 "
          + "AND status_order = 0";

  private static final String GET_LAST_ORDER_ID = "SELECT * FROM online_shop_users.users_purchases WHERE purchase_id is not null";

  private static final String UPDATE_USER_ORDER =
      "UPDATE online_shop_users.users_purchases SET status_order = 1, purchase_id = ? "
          + "WHERE user_id =? AND description = ?";

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
      addProduct.setString(8, product.getImageName());
      addProduct.setInt(9, statusOrder);

      addProduct.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static List<Product> getUserCart(User user) {
    List<Product> userBasket = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_CART);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        if (rs.getString("user_id").equals(user.getName())) {
          int id = rs.getInt("id");
          int purchase_id = rs.getInt("purchase_id");
          String brand = rs.getString("brand");
          String model = rs.getString("model");
          String type = rs.getString("type");
          String description = rs.getString("description");
          int price = rs.getInt("price");
          String imageName = rs.getString("image_name");
          userBasket.add(
              new Product(id, purchase_id, brand, model, type, description, price, imageName));
        }
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return userBasket;
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
        allOrderID.add(rs.getInt("purchase_id"));
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
      updateProduct.setString(3, product.getDescription());

      updateProduct.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
