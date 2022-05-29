package by.tms.commands;

import static by.tms.utils.PagesPathEnum.ACCOUNT_PAGE;
import static by.tms.utils.RequestParamsEnum.CURRENT_USER;

import by.tms.exceptions.CommandException;
import by.tms.model.User;
import by.tms.utils.AccountData;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccountPage implements BaseCommand {

  private static final Logger log = LogManager.getLogger(AccountPage.class);

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    HttpSession session = request.getSession();
    int userID = (int) session.getAttribute(CURRENT_USER.getValue());
    User user = AccountData.getUser(userID);
    request.setAttribute("user", user);
    log.info("getting user from session: " + user.getLogin());
    return user.getCart().getRedeemedProduct(request, user.getUserID(), ACCOUNT_PAGE.getPath());
  }
}
