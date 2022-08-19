package by.tms.eshop.services.impl;

import by.tms.eshop.dto.ProductDto;
import by.tms.eshop.dto.UserDto;
import by.tms.eshop.dto.converters.ProductConverter;
import by.tms.eshop.dto.converters.UserConverter;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

  private final OrderDao orderDao;
  private final ProductService productService;
  private final OrderDetailsDao orderDetailsDao;
  private final UserService userService;
  private final ProductConverter productConverter;
  private final UserConverter userConverter;

  public OrderServiceImpl(OrderDao orderDao, ProductService productService,
      OrderDetailsDao orderDetailsDao, UserService userService, ProductConverter productConverter,
      UserConverter userConverter) {
    this.orderDao = orderDao;
    this.productService = productService;
    this.orderDetailsDao = orderDetailsDao;
    this.userService = userService;
    this.productConverter = productConverter;
    this.userConverter = userConverter;
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
  public ResponseEntity<UserDto> getUserOrders(UserDto userDto) throws Exception {
    UserDto user = userConverter.toDto(userService.getUserData(userConverter.fromDto(userDto)));
    if (Optional.ofNullable(user).isPresent()) {
      return new ResponseEntity<>(user, HttpStatus.OK);
    }
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }
}
