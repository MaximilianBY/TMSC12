package by.tms.commands;

import static by.tms.utils.PagesPathEnum.CART_PAGE;
import static by.tms.utils.RequestParamsEnum.CURRENT_USER;
import static by.tms.utils.RequestParamsEnum.PRODUCT_ID;
import static by.tms.utils.RequestParamsEnum.STATUS;

import by.tms.exceptions.CommandException;
import by.tms.model.User;
import by.tms.utils.AccountData;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionWithUserCart implements BaseCommand {

  private static final Logger log = LogManager.getLogger(ActionWithUserCart.class);
  private User user;

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    int userID = (int) session.getAttribute(CURRENT_USER.getValue());
    user = AccountData.getUser(userID);
    actionWithUserCart(request);
    log.info("getting user from session: " + user.getLogin());
    return user.getCart().getProductListFromUserCart(session, CART_PAGE.getPath());
  }

  private void actionWithUserCart(HttpServletRequest req) {
    String orderAction = req.getParameter(STATUS.getValue());
    if (Optional.ofNullable(orderAction).isPresent()) {
      switch (orderAction) {
        case "reset_cart":
          user.getCart().flushUserCart();
          break;
        case "confirm_order":
          user.getCart().confirmOrder(user.getUserID());
          break;
        case "delete_product":
          int productID = Integer.parseInt(req.getParameter(PRODUCT_ID.getValue()));
          user.getCart().delUnnecessaryProduct(productID);
          break;
      }
    }
  }
}
