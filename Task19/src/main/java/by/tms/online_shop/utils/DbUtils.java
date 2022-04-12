package by.tms.online_shop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

  private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/online_shop_pc";
  private static String dbUserName = "root";
  private static String dbPassword = "1234";

  public static Connection getConnection() {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return connection;
  }
}
