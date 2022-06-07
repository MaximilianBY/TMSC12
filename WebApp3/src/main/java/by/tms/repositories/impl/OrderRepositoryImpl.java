package by.tms.repositories.impl;

import by.tms.entities.Order;
import by.tms.entities.Product;
import by.tms.repositories.OrderRepository;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class OrderRepositoryImpl implements OrderRepository {

  private static final String GET_USER_ORDERS =
      "SELECT * FROM eshop.orders JOIN eshop.order_product op ON orders.id = op.order_id WHERE user_id=?";
  private static final String ADD_NEW_ORDER = "INSERT INTO eshop.orders(user_id, order_date, order_price) VALUE (?, ?, ?)";
  private static final String ADD_PRODUCT_NEW_ORDER = "INSERT INTO eshop.order_product(product_id, product_quantity, order_id) VALUE (?, ?, LAST_INSERT_ID())";

  @Override
  public Map<Integer, Order> create(Order entity) {
    return null;
  }

  @Override
  public Map<Integer, Order> read() {
    return null;
  }

  @Override
  public Map<Integer, Order> update(Order entity) {
    return null;
  }

  @Override
  public void delete(int id) {

  }

  @Override
  public Map<Integer, Order> getUserOrdersFromRepository(int userID) {
    Map<Integer, Order> userOrders = new HashMap<>();
    try (Connection connection = pool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_ORDERS);

      preparedStatement.setInt(1, userID);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int orderID = rs.getInt("id");
        Date orderDate = rs.getDate("order_date");
        int orderPrice = rs.getInt("order_price");
        int productID = rs.getInt("product_id");
        int productQuantity = rs.getInt("product_quantity");
        userOrders.put(orderID, Order.builder()
            .id(orderID)
            .orderDate(orderDate)
            .orderPrice(orderPrice)
            .productID(productID)
            .productQuantity(productQuantity)
            .build());
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return userOrders;
  }

  @Override
  public Map<Integer, Order> addNewUserOrder(int userID, Product product) {
    Map<Integer, Order> userOrders = new HashMap<>();
    try (Connection connection = pool.getConnection()) {
      PreparedStatement order = connection.prepareStatement(ADD_NEW_ORDER);
      PreparedStatement productOrder = connection.prepareStatement(ADD_PRODUCT_NEW_ORDER);

      order.setInt(1, userID);
      order.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
      order.setInt(3, product.getPrice());

      productOrder.setInt(1, product.getId());
      productOrder.setInt(2, product.getQuantity());

      order.executeUpdate();
      productOrder.executeUpdate();

      userOrders = getUserOrdersFromRepository(userID);

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return userOrders;
  }
}
