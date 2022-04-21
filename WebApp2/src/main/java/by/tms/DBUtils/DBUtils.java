package by.tms.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

  private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/";
  private static String dbUserName = "root";
  private static String dbPassword = "1234";

  public static Connection getConnection() {
    Connection connection = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    return connection;
  }

  public static String getDbUserName() {
    return dbUserName;
  }

  public static String getDbPassword() {
    return dbPassword;
  }
}
