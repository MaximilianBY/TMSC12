package by.tms.db_utils;

import by.tms.model.Cart;
import by.tms.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public final class CRUDUser {

  private static Connection connection;

  private static final String GET_USERS = "SELECT * FROM eshop.user";
  private static final String ADD_NEW_USER = "INSERT INTO eshop.user(login, user_name, surname, birthday, email, phoneNumber, password) value (?, ?, ?, ?, ?, ?, ?)";

  private CRUDUser() {
    throw new java.lang.UnsupportedOperationException(
        "This is a utility class and cannot be instantiated");
  }

  public static Map<Integer, User> getUsersFromDB() {
    Map<Integer, User> userList = new HashMap<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int userID = rs.getInt("id");
        String login = rs.getString("login");
        System.out.printf(login);
        String name = rs.getString("user_name");
        String surname = rs.getString("surname");
        String birthday = rs.getString("birthday");
        String email = rs.getString("email");
        String phone_number = rs.getString("phoneNumber");
        String password = rs.getString("password");
        userList.put(userID,
            new User(userID, login, name, surname, birthday, email, phone_number, password,
                new Cart()));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return userList;
  }

  public static Map<Integer, User> addNewUser(User user) {
    Map<Integer, User> userList = new HashMap<>();
    try {
      PreparedStatement newUser = connection.prepareStatement(ADD_NEW_USER);

      newUser.setString(1, user.getLogin());
      newUser.setString(2, user.getName());
      newUser.setString(3, user.getSurname());
      newUser.setString(4, user.getBirthday());
      newUser.setString(5, user.getEmail());
      newUser.setString(6, user.getPhoneNumber());
      newUser.setString(7, user.getPassword());

      newUser.executeUpdate();

      userList = getUsersFromDB();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return userList;
  }

  public static Connection getConnection() {
    return connection;
  }

  public static void setConnection(Connection connection1) {
    connection = connection1;
  }
}
