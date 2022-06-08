package by.tms.commands;

import static by.tms.utils.PagesPathEnum.ACCOUNT_PAGE;
import static by.tms.utils.RequestParamsEnum.CATEGORY;
import static by.tms.utils.RequestParamsEnum.CURRENT_USER;
import static by.tms.utils.RequestParamsEnum.ORDER_STORY;
import static by.tms.utils.RequestParamsEnum.TOTAL_PRICE;

import by.tms.entities.Order;
import by.tms.entities.User;
import by.tms.exceptions.CommandException;
import by.tms.services.impl.CategoryServiceImpl;
import by.tms.services.impl.OrderServiceImpl;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccountCommandPageImpl implements BaseCommand {

  private static final Logger log = LogManager.getLogger(AccountCommandPageImpl.class);
  private CategoryServiceImpl categoryService = new CategoryServiceImpl();
  private OrderServiceImpl orderService = new OrderServiceImpl();

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute(CURRENT_USER.getValue());
    request.setAttribute("user", user);
    request.setAttribute(CATEGORY.getValue(), categoryService.read().values().stream().toList());
    log.info("getting user from session: " + user.getLogin());
    List<Order> redeemedProducts = orderService.getUserOrders(user.getId()).values().stream()
        .toList();
    request.setAttribute(ORDER_STORY.getValue(), redeemedProducts);
    request.setAttribute(TOTAL_PRICE.getValue(), orderService.getOrderTotalPrice(redeemedProducts));
    return ACCOUNT_PAGE.getPath();
  }
}
