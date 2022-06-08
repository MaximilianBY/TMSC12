package by.tms.commands;

import static by.tms.utils.PagesPathEnum.CART_PAGE;
import static by.tms.utils.RequestParamsEnum.CURRENT_USER;
import static by.tms.utils.RequestParamsEnum.PRODUCT_ID;
import static by.tms.utils.RequestParamsEnum.SHOPPING_CART_PRODUCTS;
import static by.tms.utils.RequestParamsEnum.STATUS;
import static by.tms.utils.RequestParamsEnum.TOTAL_PRICE;

import by.tms.entities.User;
import by.tms.exceptions.CommandException;
import by.tms.services.impl.OrderServiceImpl;
import by.tms.services.impl.ProductServiceImpl;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionWithUserCartCommandPageImpl implements BaseCommand {

  private static final Logger log = LogManager.getLogger(ActionWithUserCartCommandPageImpl.class);
  private OrderServiceImpl orderService = new OrderServiceImpl();
  private ProductServiceImpl productService = new ProductServiceImpl();
  private User user;

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    user = (User) session.getAttribute(CURRENT_USER.getValue());
    actionWithUserCart(request);
    session.setAttribute(CURRENT_USER.getValue(), user);
    log.info("getting user from session: " + user.getLogin());
    request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), user.getCart().getUsersCart());
    request.setAttribute(TOTAL_PRICE.getValue(), user.getCart().getUserCartTotalPrice());
    return CART_PAGE.getPath();
  }

  private void actionWithUserCart(HttpServletRequest req) {
    String orderAction = req.getParameter(STATUS.getValue());
    if (Optional.ofNullable(orderAction).isPresent()) {
      switch (orderAction) {
        case "reset_cart":
          user.getCart().flushUserCart();
          break;
        case "confirm_order":
          orderService.confirmOrder(user);
          break;
        case "delete_product":
          int productID = Integer.parseInt(req.getParameter(PRODUCT_ID.getValue()));
          user.getCart().delUnnecessaryProduct(productService.getProductByID(productID));
          break;
      }
    }
  }
}
