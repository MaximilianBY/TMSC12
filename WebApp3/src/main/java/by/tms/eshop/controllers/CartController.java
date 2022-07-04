package by.tms.eshop.controllers;

import static by.tms.eshop.utils.EshopConstants.SHOPPING_CART;
import static by.tms.eshop.utils.PagesPathEnum.CART_PAGE;

import by.tms.eshop.entities.User;
import by.tms.eshop.services.CartService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SessionAttributes({SHOPPING_CART})
@RequestMapping("/cart")
public class CartController {

  private static final String SHOPPING_CART = "cart";

  private final CartService cartService;

  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @GetMapping("/open")
  public ModelAndView redirectToShoppingCart(@SessionAttribute("user") User user) {
    ModelMap modelMap = new ModelMap();
    modelMap.addAttribute(SHOPPING_CART, user.getCart().getUsersCart());
    return new ModelAndView(CART_PAGE.getPath(), modelMap);
  }

  @GetMapping("/add/{id}")
  public ModelAndView addProductToCart(@SessionAttribute("user") User user,
      @PathVariable int id) throws Exception {
    return cartService.addProductToCart(id, user.getCart());
  }

  @GetMapping("/delete/{id}")
  public ModelAndView delProductFromCart(@SessionAttribute("user") User user,
      @PathVariable int id) throws Exception {
    return cartService.deleteProductFromCart(id, user.getCart());
  }

  @GetMapping("/reset")
  public ModelAndView clearUserCart(@SessionAttribute("user") User user) {
    return cartService.clearUserCart(user.getCart());
  }

  @GetMapping("/confirmOrder")
  public ModelAndView confirmOrder(@SessionAttribute("user") User user) throws Exception {
    return cartService.confirmOrder(user);
  }
}
