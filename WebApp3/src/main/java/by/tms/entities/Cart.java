package by.tms.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Cart {

  private Set<Product> productInCart;
  private Map<Integer, Set<Product>> usersCart;
  private int userID;

  public Cart(int userID) {
    this.usersCart = new HashMap<>();
    this.productInCart = new HashSet<>();
    this.userID = userID;
    this.usersCart.put(userID, productInCart);
  }

  public List<Product> getUsersCart() {
    return usersCart.get(userID).stream().toList();
  }

  public void addProductToCart(Product product1) {
    Product cloneProduct = new Product(product1);
    if (usersCart.containsKey(userID)) {
      if (usersCart.get(userID).contains(cloneProduct)) {
        usersCart.get(userID).stream()
            .filter(product -> product.equals(cloneProduct))
            .forEach(product -> {
              product.setQuantity(product.getQuantity() + 1);
              product.setPrice(product.getPrice() + cloneProduct.getPrice());
            });
      } else {
        usersCart.get(userID).add(cloneProduct);
        usersCart.get(userID).stream()
            .filter(product -> product.equals(cloneProduct))
            .forEach(product -> product.setQuantity(1));
      }
    }
//    if (usersCart.containsKey(userID) && usersCart.get(userID).containsKey(product1.getId())) {
//      usersCart.get(userID).values().stream()
//          .filter(product -> product.getId() == product1.getId())
//          .forEach(product -> {
//            product.setQuantity(product.getQuantity() + 1);
//            product.setPrice(product.getPrice() + product1.getPrice());
//          });
//    } else {
//      usersCart.get(userID).put(product1.getId(), product1);
//      usersCart.get(userID).values().stream()
//          .filter(product -> product.getId() == product1.getId())
//          .forEach(product -> product.setQuantity(1));
//    }
  }

  public void flushUserCart() {
    usersCart.get(userID).clear();
  }

  public void delUnnecessaryProduct(Product product1) {
    Product cloneProduct = new Product(product1);
    if (usersCart.containsKey(userID)) {
      usersCart.get(userID).stream()
          .filter(product -> product.equals(cloneProduct) && product.getQuantity() > 1)
          .forEach(product -> {
            product.setQuantity(product.getQuantity() - 1);
            product.setPrice(product.getPrice() - cloneProduct.getPrice());
          });
    } else {
      usersCart.get(userID)
          .removeIf(product -> product.equals(cloneProduct) && product.getQuantity() <= 1);
    }
//    if (usersCart.containsKey(userID)
//        && usersCart.get(userID).get(product1.getId()).getQuantity() == 1) {
//      usersCart.get(userID).remove(product1.getId());
//    } else {
//      usersCart.get(userID).values().stream()
//          .filter(product -> product.getId() == product1.getId() && product.getQuantity() > 1)
//          .forEach(product -> {
//            product.setQuantity(product.getQuantity() - 1);
//            product.setPrice(product.getPrice() - product1.getPrice());
//          });
//    }
  }

  public int getUserCartTotalPrice() {
    if (Optional.ofNullable(usersCart.get(userID)).isPresent()) {
      return usersCart.get(userID).stream()
          .mapToInt(Product::getPrice)
          .sum();
    }
    return 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cart cart = (Cart) o;
    return userID == cart.userID && usersCart.get(userID).equals(cart.usersCart.get(userID))
        && productInCart.equals(cart.productInCart);
  }
}
