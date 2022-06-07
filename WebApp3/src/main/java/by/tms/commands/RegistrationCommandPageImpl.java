package by.tms.commands;

import static by.tms.utils.HttpRequestParamValidator.validateParamNotNull;
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

import by.tms.entities.User;
import by.tms.exceptions.CommandException;
import by.tms.services.impl.UserServiceImpl;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationCommandPageImpl implements BaseCommand {

  private static final Logger log = LogManager.getLogger(RegistrationCommandPageImpl.class);
  private UserServiceImpl userService = new UserServiceImpl();

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    String login = request.getParameter(LOGIN.getValue());
    String name = request.getParameter(USER_NAME.getValue());
    String surname = request.getParameter(SURNAME.getValue());
    String birthday = request.getParameter(BIRTHDAY.getValue());
    String email = request.getParameter(EMAIL.getValue());
    String phoneNumber = request.getParameter(PHONE_NUMBER.getValue());
    String password = request.getParameter(PASSWORD.getValue());
    String confirmedPassword = request.getParameter(CONFIRM_PASSWORD.getValue());

    validateParamNotNull(login);
    validateParamNotNull(name);
    validateParamNotNull(surname);
    validateParamNotNull(password);
    validateParamNotNull(confirmedPassword);

    if (password.equals(confirmedPassword) && Optional.ofNullable(
        userService.findByLoginAndPassword(login, password)).isEmpty()) {
      userService.create(User.builder()
          .login(login)
          .name(name)
          .surname(surname)
          .birthday(birthday)
          .email(email)
          .phoneNumber(phoneNumber)
          .password(password)
          .build());
      log.info("created new user: " + name + " " + surname);
      return SIGN_IN_PAGE.getPath();
    }
    log.info("user not created");
    return REGISTRATION_PAGE.getPath();
  }
}