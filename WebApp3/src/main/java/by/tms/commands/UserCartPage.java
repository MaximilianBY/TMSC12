package by.tms.commands;

import static by.tms.utils.PagesPathEnum.CART_PAGE;
import static by.tms.utils.RequestParamsEnum.CURRENT_USER;

import by.tms.exceptions.CommandException;
import by.tms.model.User;
import by.tms.utils.AccountData;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserCartPage implements BaseCommand {

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    int userID = (int) session.getAttribute(CURRENT_USER.getValue());
    User user = AccountData.getUser(userID);
    return user.getCart().getProductListFromUserCart(session, CART_PAGE.getPath());
  }
}
