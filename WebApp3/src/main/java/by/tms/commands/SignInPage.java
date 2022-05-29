package by.tms.commands;

import static by.tms.utils.AccountData.getUserID;
import static by.tms.utils.AccountData.isExistUser;
import static by.tms.utils.PagesPathEnum.HOME_PAGE;
import static by.tms.utils.PagesPathEnum.SIGN_IN_PAGE;
import static by.tms.utils.RequestParamsEnum.CURRENT_USER;
import static by.tms.utils.RequestParamsEnum.LOGIN;
import static by.tms.utils.RequestParamsEnum.PASSWORD;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SignInPage implements BaseCommand {

  private static final Logger log = LogManager.getLogger(SignInPage.class);

  @Override
  public String execute(HttpServletRequest request) throws Exception {
    return checkInputUser(request);
  }

  private String checkInputUser(HttpServletRequest req) {
    HttpSession session = req.getSession();
    String login = req.getParameter(LOGIN.getValue());
    String password = req.getParameter(PASSWORD.getValue());
    if (isExistUser(login, password)) {
      session.setAttribute(CURRENT_USER.getValue(), getUserID(login));
      return HOME_PAGE.getPath();
    }
    log.info("wrong credentials");
    return SIGN_IN_PAGE.getPath();
  }
}