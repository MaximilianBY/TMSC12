package by.tms.db_utils;

import by.tms.DB_listener.DBConnectionManager;
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
import lombok.experimental.UtilityClass;

@UtilityClass
public final class CRUDUser {

  private static final String GET_USERS = "SELECT * FROM online_shop_users.users_data";
  private static final String GET_USER_BASKET = "SELECT * FROM online_shop_users.users_purchases WHERE status_order = 0";
  private static final String ADD_NEW_USER = "INSERT INTO online_shop_users.users_data(user_name, password, email, phone_number) value (?, ?, ?, ?)";
  private static final String ADD_NEW_USER_BASKET =
      "INSERT INTO online_shop_users.users_purchases(user_id, purchase_id, brand, model, type, description, price, image_name, status_order) "
          + "value (?, null, null, null, null, null, null, null, null)";
  private static final String ADD_PRODUCT_TO_BASKET =
      "INSERT INTO online_shop_users.users_purchases(user_id, purchase_id, brand, model, type, description, price, image_name, status_order)"
          + "value (?, ?, ?, ?, ?, ?, ?, ?, ?)";
  private static final String DELETE_PRODUCT_NOT_PURCHASED =
      "DELETE FROM online_shop_users.users_purchases WHERE user_id=? AND purchase_id = 0 "
          + "AND status_order = 0";

  private static final String GET_LAST_ORDER_ID = "SELECT * FROM online_shop_users.users_purchases WHERE purchase_id is not null";
  private static final String UPDATE_USER_ORDER =
      "UPDATE online_shop_users.users_purchases SET status_order = 1, purchase_id = ? "
          + "WHERE user_id =? AND description = ?";

  private static Connection connection;

  public static List<User> getUsersFromDB() {
    List<User> userList = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        List<Product> userProductList = new ArrayList<>();
        String name = rs.getString("user_name");
        System.out.println(name);
        String password = rs.getString("password");
        String email = rs.getString("email");
        String phone_number = rs.getString("phone_number");
        userList.add(new User(name, password, email, phone_number, userProductList));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return userList;
  }

  public static List<Product> getUserBasket(User user) {
    List<Product> userBasket = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BASKET);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        if (rs.getString("user_id").equals(user.getName())) {
          int purchase_id = rs.getInt("purchase_id");
          String brand = rs.getString("brand");
          String model = rs.getString("model");
          String type = rs.getString("type");
          String description = rs.getString("description");
          int price = rs.getInt("price");
          String imageName = rs.getString("image_name");
          userBasket.add(
              new Product(purchase_id, brand, model, type, description, price, imageName));
        }
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return userBasket;
  }

  public static void addNewUser(User user) {
    try {
      PreparedStatement newUser = connection.prepareStatement(ADD_NEW_USER);
      PreparedStatement newUserBasket = connection.prepareStatement(ADD_NEW_USER_BASKET);

      newUser.setString(1, user.getName());
      newUser.setString(2, user.getPassword());
      newUser.setString(3, user.getEmail());
      newUser.setString(4, user.getPhoneNumber());

      newUserBasket.setString(1, user.getName());

      newUser.executeUpdate();
      newUserBasket.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void addProductToDBBasket(User user,
      Product product, int numOrder, int statusOrder) {
    try {
      PreparedStatement addProduct = connection.prepareStatement(ADD_PRODUCT_TO_BASKET);

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

  public static void delUnnecessaryProduct(User user) {
    try {
      PreparedStatement delProduct = connection.prepareStatement(DELETE_PRODUCT_NOT_PURCHASED);

      delProduct.setString(1, user.getName());

      delProduct.executeUpdate();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static Connection getConnection() {
    return connection;
  }

  public static void setConnection(DBConnectionManager dbManager) {
    connection = dbManager.getConnection();
  }
}
