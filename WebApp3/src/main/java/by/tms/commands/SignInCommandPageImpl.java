package by.tms.commands;

import static by.tms.utils.HttpRequestParamValidator.validateParamNotNull;
import static by.tms.utils.PagesPathEnum.HOME_PAGE;
import static by.tms.utils.PagesPathEnum.SIGN_IN_PAGE;
import static by.tms.utils.RequestParamsEnum.CURRENT_USER;
import static by.tms.utils.RequestParamsEnum.LOGIN;
import static by.tms.utils.RequestParamsEnum.PASSWORD;

import by.tms.entities.User;
import by.tms.exceptions.RequestParamNullException;
import by.tms.services.impl.UserServiceImpl;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SignInCommandPageImpl implements BaseCommand {

  private static final Logger log = LogManager.getLogger(SignInCommandPageImpl.class);
  private UserServiceImpl userService = new UserServiceImpl();
  private String login;
  private String password;

  @Override
  public String execute(HttpServletRequest request) throws RequestParamNullException {
    login = request.getParameter(LOGIN.getValue());
    password = request.getParameter(PASSWORD.getValue());

    validateParamNotNull(login);
    validateParamNotNull(password);

    return checkInputUser(request);
  }

  private String checkInputUser(HttpServletRequest req) {
    User user = userService.findByLoginAndPassword(login, password);
    System.out.println(user.getName());
    if (Optional.ofNullable(user).isPresent()) {
      HttpSession session = req.getSession();
      session.setAttribute(CURRENT_USER.getValue(), user);
      return HOME_PAGE.getPath();
    }
    log.info("wrong credentials");
    return SIGN_IN_PAGE.getPath();
  }
}