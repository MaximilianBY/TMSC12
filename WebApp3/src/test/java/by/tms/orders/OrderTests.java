package by.tms.orders;

import by.tms.entities.Order;
import by.tms.services.impl.OrderServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderTests {

  private OrderServiceImpl orderService = new OrderServiceImpl();
  private Order order1;
  private Order order2;

  private Map<Integer, Order> actualOrderMap;

  private int actualSum;

  @BeforeEach
  public void setUp() {
    order1 = Order.builder()
        .id(1)
        .userID(1)
        .orderDate(new Date(1212121212121L))
        .orderPrice(1200)
        .productID(3)
        .productQuantity(2)
        .build();
    order2 = Order.builder()
        .id(2)
        .userID(1)
        .orderDate(new Date(1212121212121L))
        .orderPrice(800)
        .productID(2)
        .productQuantity(3)
        .build();

    actualOrderMap = new HashMap<>();
    actualOrderMap.put(order1.getId(), order1);
    actualOrderMap.put(order2.getId(), order2);

    actualSum = orderService.getOrderTotalPrice(actualOrderMap.values().stream().toList());
  }

  @Test
  public void getSumOrders() {
    List<Order> orders = new ArrayList<>();
    orders.add(order1);
    orders.add(order2);
    int expected = orderService.getOrderTotalPrice(orders);
    Assertions.assertEquals(expected, actualSum);
  }
}
