package by.tms.eshop.controllers;

import static by.tms.eshop.utils.EshopConstants.USER;
import static by.tms.eshop.utils.PagesPathEnum.SIGN_IN_PAGE;

import by.tms.eshop.entities.Cart;
import by.tms.eshop.entities.User;
import by.tms.eshop.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SessionAttributes({USER})
@RequestMapping("/login")
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ModelAndView openLoginPage() {
    return new ModelAndView(SIGN_IN_PAGE.getPath());
  }

  @PostMapping
  public ModelAndView login(@ModelAttribute("user") User user) throws Exception {
    return userService.authenticate(user);
  }

  @ModelAttribute(USER)
  public User setUpUserForm() {
    return User.builder()
        .cart(new Cart())
        .build();
  }
}
