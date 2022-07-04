package by.tms.eshop.services.impl;

import static by.tms.eshop.utils.EshopConstants.USER;
import static by.tms.eshop.utils.PagesPathEnum.ACCOUNT_PAGE;
import static by.tms.eshop.utils.PagesPathEnum.CATEGORY_PAGE;
import static by.tms.eshop.utils.PagesPathEnum.REGISTRATION_PAGE;
import static by.tms.eshop.utils.PagesPathEnum.SIGN_IN_PAGE;
import static by.tms.eshop.utils.RequestParamsEnum.CATEGORY;
import static by.tms.eshop.utils.RequestParamsEnum.ORDER_STORY;
import static by.tms.eshop.utils.RequestParamsEnum.TOTAL_PRICE;

import by.tms.eshop.entities.Category;
import by.tms.eshop.entities.User;
import by.tms.eshop.repositories.UserRepository;
import by.tms.eshop.services.CategoryService;
import by.tms.eshop.services.OrderService;
import by.tms.eshop.services.UserService;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private CategoryService categoryService;
  private OrderService orderService;

  public UserServiceImpl(UserRepository userRepository, CategoryService categoryService,
      OrderService orderService) {
    this.userRepository = userRepository;
    this.categoryService = categoryService;
    this.orderService = orderService;
  }

  @Override
  public void create(User entity) throws Exception {
    userRepository.create(entity);
  }

  @Override
  public Set<User> read() throws Exception {
    return userRepository.read();
  }

  @Override
  public User update(User entity) throws Exception {
    return userRepository.update(entity).stream()
        .filter(user -> user.getLogin().equals(entity.getLogin()))
        .findAny()
        .get();
  }

  @Override
  public void delete(int id) throws Exception {
    userRepository.delete(id);
  }

  @Override
  public ModelAndView authenticate(User user) throws Exception {
    ModelAndView modelAndView = new ModelAndView();
    if (Optional.ofNullable(user).isPresent()) {
      if (isExistUser(user.getLogin(), user.getPassword())) {
        ModelMap modelMap = new ModelMap();
        Set<Category> categorySet = categoryService.read();
        modelMap.addAttribute(CATEGORY.getValue(), categorySet);
        modelAndView.setViewName(CATEGORY_PAGE.getPath());
        modelAndView.addAllObjects(modelMap);
      } else {
        modelAndView.setViewName(SIGN_IN_PAGE.getPath());
      }
    }
    return modelAndView;
  }

  @Override
  public ModelAndView registration(User user) throws Exception {
    ModelAndView modelAndView = new ModelAndView();
    if (Optional.ofNullable(user).isPresent()) {
      if (!isExistUser(user.getLogin(), user.getPassword())) {
        userRepository.create(user);
        modelAndView.setViewName(SIGN_IN_PAGE.getPath());
      } else {
        modelAndView.setViewName(REGISTRATION_PAGE.getPath());
      }
    }
    return modelAndView;
  }

  @Override
  public ModelAndView getAccountData(User user) throws Exception {
    ModelAndView modelAndView = new ModelAndView();
    ModelMap modelMap = new ModelMap();
    User user1 = userRepository.getUserByLogin(user.getLogin());
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

  @Override
  public int getUserIDByLogin(String login) throws Exception {
    return userRepository.getUserIDByLogin(login);
  }

  @Override
  public User getUserByLogin(String login) throws Exception {
    return userRepository.getUserByLogin(login);
  }

  @Override
  public boolean isExistUser(String login, String password) throws Exception {
    return userRepository.read().stream()
        .anyMatch(user -> user.getLogin().equals(login) && user.getPassword().equals(password));
  }
}
