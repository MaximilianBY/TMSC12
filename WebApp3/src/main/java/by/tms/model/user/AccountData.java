package by.tms.model.user;

import static by.tms.db_utils.CRUDUser.addNewUser;
import static by.tms.db_utils.CRUDUser.getUsersFromDB;
import static by.tms.db_utils.CRUDUser.setConnection;

import by.tms.db_listener_connector.DBConnectionManager;
import java.util.List;
import java.util.Optional;

public final class AccountData {

  private static List<User> usersList;

  public static List<User> getUsersList() {
    return usersList;
  }

  private AccountData() {
    throw new java.lang.UnsupportedOperationException(
        "This is a utility class and cannot be instantiated");
  }

  public static void addUserToList(User user) {
    if (Optional.ofNullable(user).isPresent()) {
      addNewUser(user);
    }
  }

  public static void setUsersList(DBConnectionManager dbManager) {
    setConnection(dbManager);
    usersList = getUsersFromDB();
  }

  public static boolean isExistUser(User user) {
    return getUsersList().stream().anyMatch(
        user1 -> user1.getName().equals(user.getName()) && user1.getPassword()
            .equals(user.getPassword()));
  }

  public static User findUser(String userName) {
    Optional<User> user = getUsersList().stream()
        .filter(checkUser -> checkUser.getName().equals(userName)).findAny();
    return user.orElse(null);
  }
}
