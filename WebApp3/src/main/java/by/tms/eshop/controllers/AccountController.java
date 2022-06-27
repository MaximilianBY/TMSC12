package by.tms.eshop.controllers;

import static by.tms.eshop.utils.EshopConstants.USER;
import static by.tms.eshop.utils.PagesPathEnum.ACCOUNT_PAGE;
import static by.tms.eshop.utils.RequestParamsEnum.ORDER_STORY;
import static by.tms.eshop.utils.RequestParamsEnum.TOTAL_PRICE;

import by.tms.eshop.entities.User;
import by.tms.eshop.services.OrderService;
import by.tms.eshop.services.UserService;
import java.util.Optional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/account")
public class AccountController {

  private final UserService userService;
  private final OrderService orderService;

  public AccountController(UserService userService, OrderService orderService) {
    this.userService = userService;
    this.orderService = orderService;
  }

  @GetMapping
  public ModelAndView openAccountPage(@SessionAttribute("user") User user) throws Exception {
    ModelAndView modelAndView = new ModelAndView();
    ModelMap modelMap = new ModelMap();
    User user1 = userService.getUserByLogin(user.getLogin());
    if (Optional.ofNullable(user1).isPresent()) {
      modelMap.addAttribute(USER, user1);
      modelMap.addAttribute(ORDER_STORY.getValue(), orderService.getUserOrders(user1.getId()));
      modelMap.addAttribute(TOTAL_PRICE.getValue(), orderService.getOrderTotalPrice(
          orderService.getUserOrders(user1.getId()).stream().toList()));
      modelAndView.setViewName(ACCOUNT_PAGE.getPath());
      modelAndView.addAllObjects(modelMap);
      return modelAndView;
    }
    modelAndView.setViewName(ACCOUNT_PAGE.getPath());
    return modelAndView;
  }
}
