package by.tms.services.impl;

import by.tms.entities.User;
import by.tms.repositories.UserRepository;
import by.tms.repositories.impl.UserRepositoryImpl;
import by.tms.services.UserService;
import java.util.Map;

public class UserServiceImpl implements UserService {

  private UserRepository userRepository = new UserRepositoryImpl();

  @Override
  public void create(User entity) {
    userRepository.create(entity);
  }

  @Override
  public Map<Integer, User> read() {
    return userRepository.read();
  }

  @Override
  public User update(User entity) {
    return null;
  }

  @Override
  public void delete(int id) {

  }

  @Override
  public int getUserIDByLogin(String login) {
    return userRepository.getUserIDByLogin(login);
  }

  @Override
  public User findByLoginAndPassword(String login, String password) {
    return userRepository.findByLoginAndPassword(login, password);
  }
}
