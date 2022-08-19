package by.tms.eshop.services;


import by.tms.eshop.dto.ProductDto;
import by.tms.eshop.entities.Cart;
import by.tms.eshop.entities.User;
import by.tms.eshop.repositories.ProductDao;
import java.util.Optional;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CartService {

  private final ProductDao productDao;
  private final OrderService orderService;
  private final UserService userService;

  public CartService(ProductDao productDao, OrderService orderService, UserService userService) {
    this.productDao = productDao;
    this.orderService = orderService;
    this.userService = userService;
  }

  public ResponseEntity<Set<ProductDto>> openCartPage(Cart cart) {
    if (Optional.ofNullable(cart).isPresent()) {
      return new ResponseEntity<>(cart.getUsersCart(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
  }

  public ResponseEntity<Set<ProductDto>> addProductToCart(int productID, Cart cart)
      throws Exception {
    ProductDto product = productDao.getProductById(productID);
    if (Optional.ofNullable(product).isPresent()) {
      cart.addProductToCart(product);
      return new ResponseEntity<>(cart.getUsersCart(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
  }

  public ResponseEntity<Set<ProductDto>> deleteProductFromCart(int productID, Cart cart)
      throws Exception {
    ProductDto product = productDao.getProductById(productID);
    if (Optional.ofNullable(product).isPresent()) {
      cart.delUnnecessaryProduct(product);
      return new ResponseEntity<>(cart.getUsersCart(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity clearUserCart(Cart cart) {
    cart.flushUserCart();

    if (Optional.ofNullable(cart).isEmpty()) {
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
  }

  public ResponseEntity confirmOrder(User entity, Cart cart) throws Exception {
    User user = userService.getUserData(entity);
    orderService.createOrder(user, cart);
    if (Optional.ofNullable(cart).isPresent()) {
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
}
