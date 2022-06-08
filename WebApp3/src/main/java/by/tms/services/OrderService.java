package by.tms.services;

import by.tms.entities.Order;
import by.tms.entities.User;
import java.util.List;
import java.util.Map;

public interface OrderService extends BaseService<Order> {

  Map<Integer, Order> getUserOrders(int userID);

  int getOrderTotalPrice(List<Order> sumPriceOfProducts);

  void confirmOrder(User user);
}
