package by.tms.eshop.services.impl;

import by.tms.eshop.entities.Order;
import by.tms.eshop.entities.Product;
import by.tms.eshop.entities.User;
import by.tms.eshop.repositories.OrderRepository;
import by.tms.eshop.services.OrderService;
import by.tms.eshop.services.ProductService;
import by.tms.eshop.services.UserService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;
  private final ProductService productService;
  private final UserService userService;

  public OrderServiceImpl(OrderRepository orderRepository, ProductService productService,
      UserService userService) {
    this.orderRepository = orderRepository;
    this.productService = productService;
    this.userService = userService;
  }

  @Override
  public void create(Order entity) throws Exception {
    orderRepository.create(entity);
  }

  @Override
  public Set<Order> read() throws Exception {
    return orderRepository.read();
  }

  @Override
  public Order update(Order order) throws Exception {
    return orderRepository.update(order).stream().filter(order1 -> order1.getId() == order.getId())
        .findAny().orElse(null);
  }

  @Override
  public void delete(int id) throws Exception {
    orderRepository.delete(id);
  }

  @Override
  public Set<Order> getUserOrders(int userID) throws Exception {
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
  public void confirmOrder(User user) throws Exception {
    for (Product product : user.getCart().getUsersCart()) {
      productService.update(product);
      orderRepository.addNewUserOrder(userService.getUserIDByLogin(user.getLogin()), product);
    }
    user.getCart().flushUserCart();
  }
}
