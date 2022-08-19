package by.tms.eshop.services;

import by.tms.eshop.dto.UserDto;
import by.tms.eshop.entities.Cart;
import by.tms.eshop.entities.Order;
import by.tms.eshop.entities.User;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface OrderService {

  int getOrderTotalPrice(List<Order> sumPriceOfProducts);

  void createOrder(User user, Cart cart) throws Exception;

  ResponseEntity<UserDto> getUserOrders(UserDto userDto) throws Exception;
}
