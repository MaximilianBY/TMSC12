package by.tms.students.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutils {

  private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/students";
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
