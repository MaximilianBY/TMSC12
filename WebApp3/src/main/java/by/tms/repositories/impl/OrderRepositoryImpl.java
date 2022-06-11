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

  private ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

  private static final String GET_USER_ORDERS =
      "SELECT * FROM eshop.orders JOIN eshop.order_product op ON orders.id = op.order_id WHERE user_id=?";
  private static final String ADD_NEW_ORDER = "INSERT INTO eshop.orders(user_id, order_date, order_price) VALUE (?, ?, ?)";
  private static final String ADD_PRODUCT_NEW_ORDER = "INSERT INTO eshop.order_product(product_id, product_quantity, order_id) VALUE (?, ?, LAST_INSERT_ID())";
  private static final String UPDATE_ORDER = "UPDATE eshop.orders JOIN order_product op on orders.id = op.order_id SET order_date=?, order_price=?, product_id=?, product_quantity=? WHERE id=? AND user_id=?";
  private static final String DELETE_ORDER = "DELETE FROM eshop.orders WHERE id=?";

  @Override
  public Map<Integer, Order> create(Order entity) {
    Map<Integer, Order> orderMap;
    try (Connection connection = pool.getConnection()) {
      PreparedStatement addOrder = connection.prepareStatement(ADD_NEW_ORDER);
      PreparedStatement addProductOrderInfo = connection.prepareStatement(ADD_PRODUCT_NEW_ORDER);

      addOrder.setInt(1, entity.getUserID());
      addOrder.setDate(2, new java.sql.Date(entity.getOrderDate().getTime()));
      addOrder.setInt(3, entity.getOrderPrice());

      addProductOrderInfo.setInt(1, entity.getProductID());
      addProductOrderInfo.setInt(2, entity.getProductQuantity());

      addOrder.executeUpdate();
      addProductOrderInfo.executeUpdate();

      orderMap = read();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return orderMap;
  }

  @Override
  public Map<Integer, Order> read() {
    Map<Integer, Order> userOrders = new HashMap<>();
    try (Connection connection = pool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_ORDERS);
      ResultSet rs = preparedStatement.executeQuery();

      userOrders = getOrders(rs);

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return userOrders;
  }

  @Override
  public Map<Integer, Order> update(Order entity) {
    Map<Integer, Order> orderMap;
    try (Connection connection = pool.getConnection()) {
      PreparedStatement updateOrder = connection.prepareStatement(UPDATE_ORDER);

      updateOrder.setDate(1, new Date(entity.getOrderDate().getTime()));
      updateOrder.setInt(2, entity.getOrderPrice());
      updateOrder.setInt(3, entity.getProductID());
      updateOrder.setInt(4, entity.getProductQuantity());
      updateOrder.setInt(5, entity.getId());
      updateOrder.setInt(6, entity.getUserID());

      updateOrder.executeUpdate();

      orderMap = read();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return orderMap;
  }

  @Override
  public void delete(int id) {
    try (Connection connection = pool.getConnection()) {
      PreparedStatement deleteOrder = connection.prepareStatement(DELETE_ORDER);
      deleteOrder.setInt(1, id);

      deleteOrder.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Map<Integer, Order> getUserOrdersFromRepository(int userID) {
    Map<Integer, Order> userOrders = new HashMap<>();
    try (Connection connection = pool.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_ORDERS);

      preparedStatement.setInt(1, userID);
      ResultSet rs = preparedStatement.executeQuery();

      userOrders = getOrders(rs);

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

  private Map<Integer, Order> getOrders(ResultSet resultSet) throws SQLException {
    Map<Integer, Order> orderMap = new HashMap<>();
    while (resultSet.next()) {
      int orderID = resultSet.getInt("id");
      Date orderDate = resultSet.getDate("order_date");
      int orderPrice = resultSet.getInt("order_price");
      int productID = resultSet.getInt("product_id");
      Product product = productRepository.getProductByID(productID);
      int productQuantity = resultSet.getInt("product_quantity");
      orderMap.put(orderID, Order.builder()
          .id(orderID)
          .orderDate(orderDate)
          .orderPrice(orderPrice)
          .productID(productID)
          .product(product)
          .productQuantity(productQuantity)
          .build());
    }
    return orderMap;
  }
}
