package by.tms.utils;

import static by.tms.db_utils.CRUDUser.addNewUser;
import static by.tms.db_utils.CRUDUser.getUsersFromDB;
import static by.tms.db_utils.CRUDUser.setConnection;

import by.tms.db_listener_connector.DBConnectionManager;
import by.tms.model.User;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public final class AccountData {

  private static Map<Integer, User> usersList;

  private AccountData() {
    throw new java.lang.UnsupportedOperationException(
        "This is a utility class and cannot be instantiated");
  }

  static {
    try {
      setConnection(DBConnectionManager.getInstance().getConnection());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    usersList = getUsersFromDB();
  }

  public static Map<Integer, User> getUsersList() {
    return usersList;
  }

  public static void addUserToList(User user) {
    usersList = addNewUser(user);
  }

  public static boolean isExistUser(String login, String password) {
    if (Optional.ofNullable(login).isPresent() && Optional.ofNullable(password).isPresent()) {
      return usersList.values().stream().anyMatch(
          user1 -> user1.getLogin().equals(login) && user1.getPassword()
              .equals(password));
    }
    return false;
  }

  public static int getUserID(String inLogin) {
    Optional<Entry<Integer, User>> user = usersList.entrySet().stream()
        .filter(checkUser -> checkUser.getValue().getLogin().equals(inLogin)).findAny();
    if (user.isPresent()) {
      return user.map(Entry::getKey).get();
    }
    return 0;
  }

  public static User getUser(int id) {
    return usersList.get(id);
  }
}
