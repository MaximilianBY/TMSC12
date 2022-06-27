package by.tms.eshop.repositories;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Connection {

  //Singleton instance
  private static volatile Connection instance;

  //Configuration properties
  private static final String DB_PROPERTY_FILE = "application";
  private static final String DB_URL = "db.url";
  private static final String DB_LOGIN = "db.login";
  private static final String DB_PASS = "db.pass";
  private static final int MAX_CONNECTION_COUNT = 10;
  private static final int MIN_CONNECTION_COUNT = 5;

  private static String url;
  private static String login;
  private static String pass;

  static {
    ResourceBundle resourceBundle = ResourceBundle.getBundle(DB_PROPERTY_FILE);
    url = resourceBundle.getString(DB_URL);
    login = resourceBundle.getString(DB_LOGIN);
    pass = resourceBundle.getString(DB_PASS);
  }

  private static volatile int currentConnectionNumber = MIN_CONNECTION_COUNT;
  private static BlockingQueue<java.sql.Connection> pool = new ArrayBlockingQueue<>(
      MAX_CONNECTION_COUNT,
      true);

  //Singleton
  public static Connection getInstance() {
    if (instance == null) {
      synchronized (Connection.class) {
        if (instance == null) {
          instance = new Connection();
        }
      }
    }

    return instance;
  }

  //Add new connection to queue in constructor
  private Connection() {
    for (int i = 0; i < MIN_CONNECTION_COUNT; i++) {
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        pool.add(DriverManager.getConnection(url, login, pass));
      } catch (SQLException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private void openAdditionalConnection() throws Exception {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      pool.add(DriverManager.getConnection(url, login, pass));
      currentConnectionNumber++;
    } catch (SQLException e) {
      throw new Exception("New connection wasn't add in the connection pool", e);
    }
  }

  public java.sql.Connection getConnection() throws Exception {
    java.sql.Connection connection;
    try {
      if (pool.isEmpty() && currentConnectionNumber < MAX_CONNECTION_COUNT) {
        openAdditionalConnection();
      }
      connection = pool.take();
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
      throw new Exception("Max count of connections was reached!");
    }

    return connection;
  }

  public static void closeConnection(java.sql.Connection connection) throws Exception {
    if (connection != null) {
      if (currentConnectionNumber > MIN_CONNECTION_COUNT) {
        currentConnectionNumber--;
      }
      try {
        pool.put(connection);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new Exception("Connection wasn't returned into pool properly");
      }
    }
  }
}
