package by.tms.users;

import by.tms.entities.User;
import by.tms.services.impl.UserServiceImpl;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserTests {

  private UserServiceImpl userService = new UserServiceImpl();
  private static User user1;
  private static User user2;
  private static User user3;
  private static User user4;

  private static Map<Integer, User> actual;
  private static User actualByLoginAndPassword;
  private static int actualIDByLogin;

  @BeforeAll
  public static void setUp() {
    user1 = User.builder()
        .id(1)
        .login("Max")
        .name("Maximilian")
        .surname("Poltorzhickiy")
        .birthday("1990.01.01")
        .email("max@gmail.com")
        .phoneNumber("+375259457864")
        .password("1234")
        .build();
    user2 = User.builder()
        .id(2)
        .login("Anna")
        .name("Anna")
        .surname("Kovrizhnih")
        .birthday("1992.07.14")
        .email("anna@gmail.com")
        .phoneNumber("+375252542354")
        .password("12345")
        .build();
    user3 = User.builder()
        .id(3)
        .login("Alia")
        .name("Alina")
        .surname("Poltorzhickaya")
        .birthday("1988.10.15")
        .email("alina.box@gmail.com")
        .phoneNumber("+375293569784")
        .password("4321")
        .build();
    user4 = User.builder()
        .id(4)
        .login("Vas")
        .name("Vasya")
        .surname("Ivanov")
        .birthday("1986.02.21")
        .email("vasya.boss@gmail.com")
        .phoneNumber("+375337854312")
        .password("54321")
        .build();

    actual = new HashMap<>();
    actual.put(user1.getId(), user1);
    actual.put(user2.getId(), user2);
    actual.put(user3.getId(), user3);
    actual.put(user4.getId(), user4);

    actualByLoginAndPassword = user3;

    actualIDByLogin = user1.getId();
  }

  @Test
  public void checkAllUsersReturned() {
    Map<Integer, User> expected = userService.read();
    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void checkAllUserReturned_NotNull() {
    Map<Integer, User> expected = userService.read();
    Assertions.assertNotNull(expected);
  }

  @Test
  public void getUserByLoginAndPassword() {
    User expected = userService.findByLoginAndPassword("Alia", "4321");
    Assertions.assertEquals(expected, actualByLoginAndPassword);
  }

  @Test
  public void getUserIdByLogin() {
    int expected = userService.getUserIDByLogin("Max");
    Assertions.assertEquals(expected, actualIDByLogin);
  }
}
