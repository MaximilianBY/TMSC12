package by.tms.eshop.services;

import by.tms.eshop.dto.CategoryDto;
import by.tms.eshop.dto.UserDto;
import by.tms.eshop.entities.User;
import by.tms.eshop.exceptions.AuthorizationException;
import java.util.Set;
import org.springframework.http.ResponseEntity;

public interface UserService {

  ResponseEntity<Set<CategoryDto>> authenticate(UserDto user) throws AuthorizationException;

  ResponseEntity<UserDto> registration(UserDto user) throws Exception;

  User getUserData(User entity);

  int getUserIDByLogin(String login) throws Exception;

  User isExistUser(String login, String password);

  boolean checkUserEntry(User user);
}
