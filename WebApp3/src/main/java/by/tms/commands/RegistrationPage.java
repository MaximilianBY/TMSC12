package by.tms.commands;

import static by.tms.utils.AccountData.addUserToList;
import static by.tms.utils.AccountData.isExistUser;
import static by.tms.utils.PagesPathEnum.REGISTRATION_PAGE;
import static by.tms.utils.PagesPathEnum.SIGN_IN_PAGE;
import static by.tms.utils.RequestParamsEnum.BIRTHDAY;
import static by.tms.utils.RequestParamsEnum.CONFIRM_PASSWORD;
import static by.tms.utils.RequestParamsEnum.EMAIL;
import static by.tms.utils.RequestParamsEnum.LOGIN;
import static by.tms.utils.RequestParamsEnum.PASSWORD;
import static by.tms.utils.RequestParamsEnum.PHONE_NUMBER;
import static by.tms.utils.RequestParamsEnum.SURNAME;
import static by.tms.utils.RequestParamsEnum.USER_NAME;

import by.tms.exceptions.CommandException;
import by.tms.model.User;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationPage implements BaseCommand {

  private static final Logger log = LogManager.getLogger(RegistrationPage.class);

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    String login = request.getParameter(LOGIN.getValue());
    String userName = request.getParameter(USER_NAME.getValue());
    String lastName = request.getParameter(SURNAME.getValue());
    String birthday = request.getParameter(BIRTHDAY.getValue());
    String email = request.getParameter(EMAIL.getValue());
    String phoneNumber = request.getParameter(PHONE_NUMBER.getValue());
    String pass = request.getParameter(PASSWORD.getValue());
    String confPass = request.getParameter(CONFIRM_PASSWORD.getValue());

    if ((Optional.ofNullable(login).isPresent() && Optional.ofNullable(userName).isPresent()
        && Optional.ofNullable(lastName).isPresent()) && pass.equals(confPass)) {
      User user = new User(login, userName, lastName, birthday, email, phoneNumber, pass);
      if (!isExistUser(user.getLogin(), user.getPassword())) {
        addUserToList(user);
        log.info("created new user: " + userName + " " + lastName);
        return SIGN_IN_PAGE.getPath();
      }
    }
    return REGISTRATION_PAGE.getPath();
  }
}