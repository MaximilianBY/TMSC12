package by.tms.db_utils;

import by.tms.db_listener_connector.DBConnectionManager;
import by.tms.model.user.User;
import by.tms.product.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class CRUDUser {

  private static Connection connection;

  private static final String GET_USERS = "SELECT * FROM online_shop_users.users_data";
  private static final String ADD_NEW_USER = "INSERT INTO online_shop_users.users_data(user_name, password, email, phone_number) value (?, ?, ?, ?)";
  private static final String ADD_NEW_USER_BASKET =
      "INSERT INTO online_shop_users.users_purchases(user_id, purchase_id, brand, model, type, description, price, image_name, status_order) "
          + "value (?, null, null, null, null, null, null, null, null)";

  private CRUDUser() {
    throw new java.lang.UnsupportedOperationException(
        "This is a utility class and cannot be instantiated");
  }

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

  public static Connection getConnection() {
    return connection;
  }

  public static void setConnection(DBConnectionManager dbManager) {
    connection = dbManager.getConnection();
  }
}
