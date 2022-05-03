package by.tms.model.registry;

import static by.tms.db_utils.CRUDProduct.updateQuantityProducts;
import static by.tms.db_utils.CRUDUser.addNewUser;
import static by.tms.db_utils.CRUDUser.addProductToDBBasket;
import static by.tms.db_utils.CRUDUser.delUnnecessaryProduct;
import static by.tms.db_utils.CRUDUser.getLastOrderID;
import static by.tms.db_utils.CRUDUser.getUserBasket;
import static by.tms.db_utils.CRUDUser.getUsersFromDB;
import static by.tms.db_utils.CRUDUser.setConnection;
import static by.tms.db_utils.CRUDUser.updateOrder;

import by.tms.DB_listener.DBConnectionManager;
import by.tms.model.product.Product;
import by.tms.model.user.User;
import java.util.List;
import java.util.Optional;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class AccountData {

  private static List<User> usersList;

  public static List<User> getUsersList() {
    return usersList;
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

  public static void addProductToUserBasket(String userName,
      Product product, int numOrder, int statusOrder) {
    User user = findUser(userName);
    if (Optional.ofNullable(user).isPresent()) {
      addProductToDBBasket(user, product, numOrder, statusOrder);
    }
  }

  public static void clearUserBasket(String userName) {
    User user = findUser(userName);
    if (Optional.ofNullable(user).isPresent()) {
      delUnnecessaryProduct(user);
    }
  }

  public static List<Product> getProductListFromUserBasket(String userName) {
    User user = findUser(userName);
    if (Optional.ofNullable(user).isPresent()) {
      return getUserBasket(user);
    }
    return null;
  }

  private static User findUser(String userName) {
    Optional<User> user = getUsersList().stream()
        .filter(checkUser -> checkUser.getName().equals(userName)).findAny();
    return user.orElse(null);
  }

  public static boolean checkUser(String userName, String password) {
    return getUsersList().stream().anyMatch(
        user -> user.getName().equals(userName) && user.getPassword()
            .equals(password));
  }

  public void confirmOrder(String userName, List<Product> userBasket) {
    int orderID = getLastOrderID() + 1;
    User user = findUser(userName);
    if (Optional.ofNullable(user).isPresent() && Optional.ofNullable(userBasket).isPresent()) {
      for (Product product : userBasket) {
        updateQuantityProducts(product);
        updateOrder(user, product, orderID);
      }
    }
  }
}
