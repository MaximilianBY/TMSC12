package by.tms.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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
    if (productInCart.contains(product1)) {
      productInCart.stream()
          .filter(product -> product.equals(product1))
          .forEach(product -> {
            product.setQuantity(product.getQuantity() + 1);
            product.setPrice(product.getQuantity() * product1.getPrice());
          });
    } else {
      productInCart.add(product1);
      productInCart.stream()
          .filter(product -> product.equals(product1))
          .forEach(product -> product.setQuantity(1));
    }
  }

  public void flushUserCart() {
    productInCart.clear();
  }

  public void delUnnecessaryProduct(Product product1) {
    productInCart.removeIf(product -> {
      if (product.equals(product1) && product.getQuantity() <= 1) {
        return true;
      } else {
        product.setQuantity(product.getQuantity() - 1);
        product.setPrice(product.getPrice() - product1.getPrice());
        return false;
      }
    });
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

  @Override
  public int hashCode() {
    return Objects.hash(productInCart);
  }
}
