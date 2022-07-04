package by.tms.eshop.services;

import by.tms.eshop.entities.User;
import org.springframework.web.servlet.ModelAndView;

public interface UserService extends BaseService<User> {

  ModelAndView authenticate(User user) throws Exception;

  ModelAndView registration(User user) throws Exception;

  ModelAndView getAccountData(User user) throws Exception;

  int getUserIDByLogin(String login) throws Exception;

  User getUserByLogin(String login) throws Exception;

  boolean isExistUser(String login, String password) throws Exception;
}
