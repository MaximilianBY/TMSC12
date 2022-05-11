package by.tms.model.cart;

import static by.tms.db_utils.CRUDCart.addProductToDBCart;
import static by.tms.db_utils.CRUDCart.delAllUnnecessaryProducts;
import static by.tms.db_utils.CRUDCart.getLastOrderID;
import static by.tms.db_utils.CRUDCart.getUserCart;
import static by.tms.db_utils.CRUDCart.updateOrder;
import static by.tms.db_utils.CRUDProduct.updateQuantityProducts;
import static by.tms.model.user.AccountData.findUser;

import by.tms.model.product.Product;
import by.tms.model.user.User;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Cart {

  public static void addProductToUserCart(String userName,
      Product product, int numOrder, int statusOrder) {
    User user = findUser(userName);
    if (Optional.ofNullable(user).isPresent()) {
      addProductToDBCart(user, product, numOrder, statusOrder);
    }
  }

  public static Map<Integer, Product> getProductListFromUserCart(String userName) {
    User user = findUser(userName);
    if (Optional.ofNullable(user).isPresent()) {
      return getUserCart(user);
    }
    return null;
  }

  public static void confirmOrder(String userName, List<Product> userCart) {
    int orderID = getLastOrderID() + 1;
    User user = findUser(userName);
    if (Optional.ofNullable(user).isPresent() && Optional.ofNullable(userCart).isPresent()) {
      for (Product product : userCart) {
        updateQuantityProducts(product);
        updateOrder(user, product, orderID);
      }
    }
  }

  public static void clearUserCart(String userName, int id) {
    User user = findUser(userName);
    if (Optional.ofNullable(user).isPresent()) {
      delAllUnnecessaryProducts(user, id);
    }
  }
}
