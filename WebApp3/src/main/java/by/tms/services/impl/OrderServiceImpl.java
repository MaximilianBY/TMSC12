package by.tms.services.impl;

import static by.tms.utils.RequestParamsEnum.ORDER_STORY;
import static by.tms.utils.RequestParamsEnum.TOTAL_PRICE;

import by.tms.entities.Cart;
import by.tms.entities.Order;
import by.tms.entities.Product;
import by.tms.entities.User;
import by.tms.repositories.impl.OrderRepositoryImpl;
import by.tms.services.OrderService;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

public class OrderServiceImpl implements OrderService {

  private OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();
  private ProductServiceImpl productService = new ProductServiceImpl();

  @Override
  public void create(Order entity) {

  }

  @Override
  public Map<Integer, Order> read() {
    return null;
  }

  @Override
  public Order update(Order entity) {
    return null;
  }

  @Override
  public void delete(int id) {

  }

  @Override
  public Map<Integer, Order> getUserOrders(int userID) {
    return orderRepository.getUserOrdersFromRepository(userID);
  }

  @Override
  public int getOrderTotalPrice(Map<Integer, Order> sumPriceOfProducts) {
    if (Optional.ofNullable(sumPriceOfProducts).isPresent()) {
      return sumPriceOfProducts.values().stream()
          .mapToInt(Order::getOrderPrice)
          .sum();
    }
    return 0;
  }

  public String getRedeemedProduct(HttpServletRequest request, int userID, String url) {
    Map<Integer, Order> redeemedProducts = getUserOrders(userID);
    request.setAttribute(ORDER_STORY.getValue(), redeemedProducts.values().stream().toList());
    request.setAttribute(TOTAL_PRICE.getValue(), getOrderTotalPrice(redeemedProducts));

    return url;
  }

  @Override
  public void confirmOrder(User user, Cart cart) {
    for (Product product : cart.getUsersCart()) {
      productService.update(product);
      orderRepository.addNewUserOrder(user.getId(), product);
    }
    cart.flushUserCart();
  }
}
