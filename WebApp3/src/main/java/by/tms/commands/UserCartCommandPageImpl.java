package by.tms.commands;

import static by.tms.utils.PagesPathEnum.CART_PAGE;
import static by.tms.utils.RequestParamsEnum.CURRENT_USER;
import static by.tms.utils.RequestParamsEnum.CURRENT_USER_CART;
import static by.tms.utils.RequestParamsEnum.SHOPPING_CART_PRODUCTS;
import static by.tms.utils.RequestParamsEnum.TOTAL_PRICE;

import by.tms.entities.Cart;
import by.tms.entities.User;
import by.tms.exceptions.CommandException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserCartCommandPageImpl implements BaseCommand {

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute(CURRENT_USER.getValue());
    Cart cart = (Cart) session.getAttribute(CURRENT_USER_CART.getValue());
    request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), cart.getUsersCart());
    request.setAttribute(TOTAL_PRICE.getValue(), cart.getUserCartTotalPrice());
    return CART_PAGE.getPath();
  }
}
