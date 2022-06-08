package by.tms.services.impl;

import by.tms.entities.Order;
import by.tms.entities.Product;
import by.tms.entities.User;
import by.tms.repositories.impl.OrderRepositoryImpl;
import by.tms.services.OrderService;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

  private OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();
  private ProductServiceImpl productService = new ProductServiceImpl();

  @Override
  public void create(Order entity) {
    orderRepository.create(entity);
  }

  @Override
  public Map<Integer, Order> read() {
    return orderRepository.read();
  }

  @Override
  public Order update(Order entity) {
    return orderRepository.update(entity).get(entity.getId());
  }

  @Override
  public void delete(int id) {
    orderRepository.delete(id);
  }

  @Override
  public Map<Integer, Order> getUserOrders(int userID) {
    return orderRepository.getUserOrdersFromRepository(userID);
  }

  @Override
  public int getOrderTotalPrice(List<Order> sumPriceOfProducts) {
    if (Optional.ofNullable(sumPriceOfProducts).isPresent()) {
      return sumPriceOfProducts.stream()
          .mapToInt(Order::getOrderPrice)
          .sum();
    }
    return 0;
  }

  @Override
  public void confirmOrder(User user) {
    for (Product product : user.getCart().getUsersCart()) {
      productService.update(product);
      orderRepository.addNewUserOrder(user.getId(), product);
    }
    user.getCart().flushUserCart();
  }
}
