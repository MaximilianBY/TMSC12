package by.tms.eshop.services;

import static by.tms.eshop.utils.EshopConstants.SHOPPING_CART;
import static by.tms.eshop.utils.PagesPathEnum.CART_PAGE;
import static by.tms.eshop.utils.RequestParamsEnum.PRODUCT;
import static by.tms.eshop.utils.RequestParamsEnum.TOTAL_PRICE;

import by.tms.eshop.entities.Cart;
import by.tms.eshop.entities.Product;
import by.tms.eshop.entities.User;
import by.tms.eshop.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
public class CartService {

  private final ProductRepository productRepository;
  private final OrderService orderService;

  public CartService(ProductRepository productRepository, OrderService orderService) {
    this.productRepository = productRepository;
    this.orderService = orderService;
  }

  public ModelAndView addProductToCart(int productID, Cart cart) throws Exception {
    ModelMap modelMap = new ModelMap();

    Product product = productRepository.getProductByID(productID);
    cart.addProductToCart(product);

    modelMap.addAttribute(PRODUCT.getValue(), product);
    modelMap.addAttribute(SHOPPING_CART, cart.getUsersCart());
    modelMap.addAttribute(TOTAL_PRICE.getValue(), cart.getUserCartTotalPrice());
    return new ModelAndView(CART_PAGE.getPath(), modelMap);
  }

  public ModelAndView deleteProductFromCart(int productID, Cart cart) throws Exception {
    ModelMap modelMap = new ModelMap();

    Product product = productRepository.getProductByID(productID);
    cart.delUnnecessaryProduct(product);

    modelMap.addAttribute(SHOPPING_CART, cart.getUsersCart());
    modelMap.addAttribute(TOTAL_PRICE.getValue(), cart.getUserCartTotalPrice());
    return new ModelAndView(CART_PAGE.getPath(), modelMap);
  }

  public ModelAndView clearUserCart(Cart cart) {
    ModelMap modelMap = new ModelMap();

    cart.flushUserCart();

    modelMap.addAttribute(SHOPPING_CART, cart.getUsersCart());
    modelMap.addAttribute(TOTAL_PRICE.getValue(), cart.getUserCartTotalPrice());
    return new ModelAndView(CART_PAGE.getPath(), modelMap);
  }

  public ModelAndView confirmOrder(User user) throws Exception {
    ModelMap modelMap = new ModelMap();

    orderService.confirmOrder(user);
    modelMap.addAttribute(SHOPPING_CART, user.getCart().getUsersCart());
    modelMap.addAttribute(TOTAL_PRICE.getValue(), user.getCart().getUserCartTotalPrice());
    return new ModelAndView(CART_PAGE.getPath(), modelMap);
  }
}
