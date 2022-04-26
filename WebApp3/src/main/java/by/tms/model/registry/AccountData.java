package by.tms.model.registry;


import by.tms.model.user.User;
import java.util.ArrayList;
import java.util.List;

public final class AccountData {

  private static List<User> usersList = new ArrayList<>();

  public static List<User> getUsersList() {
    return usersList;
  }

  public static void addUserToList(User user) {
    usersList.add(user);
  }

  public static boolean checkUser(User user) {
    return AccountData.getUsersList().stream().anyMatch(
        user1 -> user1.getName().equals(user.getName()) && user1.getPassword()
            .equals(user.getPassword()));
  }
}
