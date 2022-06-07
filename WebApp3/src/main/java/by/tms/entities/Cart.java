package by.tms.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Cart {

  private Set<Product> productInCart;

  public Cart() {
    this.productInCart = new HashSet<>();
  }

  public List<Product> getUsersCart() {
    return productInCart.stream().toList();
  }

  public void addProductToCart(Product product1) {
    Product cloneProduct = new Product(product1);
    if (productInCart.contains(cloneProduct)) {
      productInCart.stream()
          .filter(product -> product.equals(cloneProduct))
          .forEach(product -> {
            product.setQuantity(product.getQuantity() + 1);
            product.setPrice(product.getPrice() + cloneProduct.getPrice());
          });
    } else {
      productInCart.add(cloneProduct);
      productInCart.stream()
          .filter(product -> product.equals(cloneProduct))
          .forEach(product -> product.setQuantity(1));
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
    productInCart.clear();
  }

  public void delUnnecessaryProduct(Product product1) {
    Product cloneProduct = new Product(product1);
    productInCart.removeIf(product -> product.equals(cloneProduct) && product.getQuantity() <= 1);
    productInCart.stream()
        .filter(product -> product.equals(cloneProduct) && product.getQuantity() > 1)
        .forEach(product -> {
          product.setQuantity(product.getQuantity() - 1);
          product.setPrice(product.getPrice() - cloneProduct.getPrice());
        });
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
    if (Optional.ofNullable(productInCart).isPresent()) {
      return productInCart.stream()
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
    return productInCart.equals(cart.productInCart);
  }
}
