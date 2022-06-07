package by.tms.services;

import by.tms.entities.Cart;
import by.tms.entities.Order;
import by.tms.entities.User;
import java.util.Map;

public interface OrderService extends BaseService<Order> {

  Map<Integer, Order> getUserOrders(int userID);

  int getOrderTotalPrice(Map<Integer, Order> sumPriceOfProducts);

  void confirmOrder(User user, Cart cart);
}
