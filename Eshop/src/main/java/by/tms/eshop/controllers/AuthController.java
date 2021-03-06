package by.tms.eshop.controllers;

import static by.tms.eshop.EshopConstants.SHOPPING_CART;
import static by.tms.eshop.EshopConstants.USER;
import static by.tms.eshop.PagesPathConstants.SIGN_IN_PAGE;

import by.tms.eshop.entities.Cart;
import by.tms.eshop.entities.User;
import by.tms.eshop.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@SessionAttributes({USER, SHOPPING_CART})
@RequestMapping("/login")
public class AuthController {

  private static final String SHOPPING_CART = "cart";
  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ModelAndView openLoginPage() {
    return new ModelAndView(SIGN_IN_PAGE);
  }

  @PostMapping
  public ModelAndView login(@ModelAttribute("user") User user,
      @ModelAttribute(SHOPPING_CART) Cart shopCart)
      throws Exception {
    return userService.authenticate(user);
  }

  @ModelAttribute(USER)
  public User setUpUserForm() {
    return new User();
  }

  @ModelAttribute(SHOPPING_CART)
  public Cart shoppingCart() {
    return new Cart();
  }
}
