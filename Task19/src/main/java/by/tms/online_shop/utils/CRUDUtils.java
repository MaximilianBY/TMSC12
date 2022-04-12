package by.tms.online_shop.utils;

import by.tms.online_shop.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {

  private static String GET_ALL_PRODUCT_QUERY = "SELECT * FROM product_db";
  private static String INSERT_NEW_PRODUCT_QUERY = "INSERT INTO product_db(name, model, reviews, price, current_availability) VALUES(?, ?, ?, ?, ?);";
  private static String UPDATE_PRODUCT_QUERY = "UPDATE product_db SET reviews = ?,  current_availability = ? WHERE id = ?;";
  private static String DELETE_PRODUCT_QUERY = "DELETE FROM product_db WHERE id = ?";

  public static List<Product> getAllProduct() {
    List<Product> getProductList = new ArrayList<>();

    try (Connection connection = DbUtils.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCT_QUERY);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String model = resultSet.getString("model");
        String reviews = resultSet.getString("reviews");
        int price = resultSet.getInt("price");
        int currentAvailability = resultSet.getInt("current_availability");
        getProductList.add(new Product(id, name, model, reviews, price, currentAvailability));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return getProductList;
  }

  public static List<Product> insertNewProduct(Product product) {
    List<Product> updatedProductList = new ArrayList<>();

    try (Connection connection = DbUtils.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_PRODUCT_QUERY);

      preparedStatement.setString(1, product.getName());
      preparedStatement.setString(2, product.getModel());
      preparedStatement.setString(3, product.getReviews());
      preparedStatement.setInt(4, product.getPrice());
      preparedStatement.setInt(5, product.getCurrentAvailability());
      preparedStatement.executeUpdate();

      updatedProductList = getAllProduct();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return updatedProductList;
  }

  public static List<Product> updateProductDescription(int productID, String reviews,
      int currentAvailability) {
    List<Product> updatedProductList = new ArrayList<>();

    try (Connection connection = DbUtils.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_QUERY);

      preparedStatement.setInt(1, productID);
      preparedStatement.setString(2, reviews);
      preparedStatement.setInt(3, currentAvailability);
      preparedStatement.executeUpdate();

      updatedProductList = getAllProduct();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return updatedProductList;
  }

  public static List<Product> deleteProductFromDB(int productID) {
    List<Product> updatedProductList = new ArrayList<>();

    try (Connection connection = DbUtils.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_QUERY);

      preparedStatement.setInt(1, productID);
      preparedStatement.execute();

      updatedProductList = getAllProduct();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return updatedProductList;
  }
}
