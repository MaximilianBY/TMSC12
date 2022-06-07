package by.tms.services;

import by.tms.entities.User;

public interface UserService extends BaseService<User> {

  int getUserIDByLogin(String login);

  User findByLoginAndPassword(String login, String password);
}
