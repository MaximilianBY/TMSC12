package by.tms.eshop.services.impl;

import by.tms.eshop.dto.UserDto;
import by.tms.eshop.dto.converters.UserConverter;
import by.tms.eshop.entities.User;
import by.tms.eshop.repositories.UserDao;
import by.tms.eshop.services.CategoryService;
import by.tms.eshop.services.UserService;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  private final UserDao userDao;
  private final CategoryService categoryService;
  private final UserConverter userConverter;

  public UserServiceImpl(UserDao userDao, CategoryService categoryService,
      UserConverter userConverter) {
    this.userDao = userDao;
    this.categoryService = categoryService;
    this.userConverter = userConverter;
  }

  @Override
  public ResponseEntity<UserDto> authenticate(UserDto user) {
    log.info("inside check user");
    if (checkUserEntry(userConverter.fromDto(user))) {
      UserDto userFromDb = userConverter.toDto(
          userDao.findUserByLoginAndPassword(user.getLogin(), user.getPassword()));
      if (Optional.ofNullable(userFromDb).isPresent()) {
        log.info("inside user checked, loading category");
        return new ResponseEntity<>(userFromDb, HttpStatus.OK);
      }
    }
    log.info("user not exist");
    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
  }

  @Override
  public ResponseEntity<UserDto> registration(UserDto user) {
    log.info("inside registration user");
    log.info(user.getLogin() + " " + user.getName());
    if (checkUserEntry(userConverter.fromDto(user))) {
//      UserDto newUser = userConverter.toDto(
//          userDao.findUserByLoginAndPassword(user.getLogin(), user.getPassword()));
//      if (Optional.ofNullable(newUser).isEmpty()) {
      return new ResponseEntity<>(user, HttpStatus.OK);
//      }
    }
    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
  }

  @Override
  public User getUserData(User entity) {
    User user = userDao.getUserByLogin(entity);
    return user;
  }

  @Override
  public int getUserIDByLogin(String login) throws Exception {
    return 0;
  }

  @Override
  public User isExistUser(String login, String password) {
    return userDao.isExistUser(login, password);
  }

  @Override
  public boolean checkUserEntry(User user) {
    return Optional.ofNullable(user).isPresent() && Optional.ofNullable(user.getLogin()).isPresent()
        && Optional.ofNullable(user.getPassword()).isPresent();
  }
}
