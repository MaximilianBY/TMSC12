package by.tms.eshop.services.impl;

import static by.tms.eshop.PagesPathConstants.ACCOUNT_PAGE;
import static by.tms.eshop.RequestParamsEnum.ORDER_DETAILS;
import static by.tms.eshop.RequestParamsEnum.TOTAL_PRICE;
import static by.tms.eshop.RequestParamsEnum.USER_INFO;

import by.tms.eshop.dto.ProductDto;
import by.tms.eshop.dto.converters.ProductConverter;
import by.tms.eshop.entities.Cart;
import by.tms.eshop.entities.Order;
import by.tms.eshop.entities.OrderDetails;
import by.tms.eshop.entities.OrderDetailsId;
import by.tms.eshop.entities.User;
import by.tms.eshop.repositories.OrderDao;
import by.tms.eshop.repositories.OrderDetailsDao;
import by.tms.eshop.services.OrderService;
import by.tms.eshop.services.ProductService;
import by.tms.eshop.services.UserService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

  private final OrderDao orderDao;
  private final ProductService productService;
  private final OrderDetailsDao orderDetailsDao;
  private final UserService userService;
  private final ProductConverter productConverter;

  public OrderServiceImpl(OrderDao orderDao, ProductService productService,
      OrderDetailsDao orderDetailsDao, UserService userService, ProductConverter productConverter) {
    this.orderDao = orderDao;
    this.productService = productService;
    this.orderDetailsDao = orderDetailsDao;
    this.userService = userService;
    this.productConverter = productConverter;
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
  public void createOrder(User user, Cart cart) throws Exception {
    Order order = Order.builder()
        .user(user)
        .orderDate(LocalDate.now())
        .orderPrice(cart.getUserCartTotalPrice())
        .build();
    orderDao.saveOrder(order);
    for (ProductDto product : cart.getUsersCart()) {
      productService.updateProductQuantity(product);

      OrderDetailsId orderDetailsId = OrderDetailsId.builder()
          .order(order)
          .product(productConverter.fromDto(product))
          .build();

      OrderDetails orderDetails = OrderDetails.builder()
          .orderDetailsId(orderDetailsId)
          .quantity(product.getQuantity())
          .build();

      orderDetailsDao.saveOrderDetails(orderDetails);

    }
    cart.flushUserCart();
  }

  @Override
  public ModelAndView getUserOrders(User entity) throws Exception {
    ModelMap modelMap = new ModelMap();
    User user = userService.getUserData(entity);
    modelMap.addAttribute(USER_INFO.getValue(), user);
    Set<Order> userOrders = orderDao.getUserOrders(user);
    Set<OrderDetails> orderDetails = orderDetailsDao.getOrderDetails(user);
    if (Optional.ofNullable(orderDetails).isPresent()) {
//      modelMap.addAttribute(ORDER_STORY.getValue(), userOrders);
      modelMap.addAttribute(ORDER_DETAILS.getValue(), orderDetails);
      int totalOrderPrice = userOrders.stream().mapToInt(Order::getOrderPrice).sum();
      modelMap.addAttribute(TOTAL_PRICE.getValue(), totalOrderPrice);
    }
    return new ModelAndView(ACCOUNT_PAGE, modelMap);
  }
}
