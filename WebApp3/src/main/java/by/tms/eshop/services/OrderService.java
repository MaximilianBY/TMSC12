package by.tms.eshop.services;

import by.tms.eshop.entities.Order;
import by.tms.eshop.entities.User;
import java.util.List;
import java.util.Set;

public interface OrderService extends BaseService<Order> {

  Set<Order> getUserOrders(int userID) throws Exception;

  int getOrderTotalPrice(List<Order> sumPriceOfProducts);

  void confirmOrder(User user) throws Exception;
}
