package by.tms.eshop.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Cart {

  private Set<Product> productInCart;

  public Cart() {
    this.productInCart = new HashSet<>();
  }

  public Set<Product> getUsersCart() {
    return productInCart;
  }

  public void addProductToCart(Product addedProduct) {
    if (isExistProductInCart(addedProduct)) {
      productInCart.stream()
          .filter(product -> product.getId() == addedProduct.getId())
          .forEach(product -> {
            product.setQuantity(product.getQuantity() + 1);
            product.setPrice(product.getQuantity() * addedProduct.getPrice());
          });
    } else {
      productInCart.add(Product.builder()
          .id(addedProduct.getId())
          .brand(addedProduct.getBrand())
          .model(addedProduct.getModel())
          .quantity(1)
          .price(addedProduct.getPrice())
          .imagePath(addedProduct.getImagePath())
          .build());
    }
  }

  public int getUserCartTotalPrice() {
    if (Optional.ofNullable(productInCart).isPresent()) {
      return productInCart.stream()
          .mapToInt(Product::getPrice)
          .sum();
    }
    return 0;
  }

  public void delUnnecessaryProduct(Product productToRemove) {
    productInCart.removeIf(product -> {
      if (product.getId() == productToRemove.getId() && product.getQuantity() <= 1) {
        return true;
      } else {
        if (product.getId() == productToRemove.getId()) {
          product.setQuantity(product.getQuantity() - 1);
          product.setPrice(product.getPrice() - productToRemove.getPrice());
          return false;
        }
      }
      return false;
    });
  }

  public void flushUserCart() {
    productInCart.clear();
  }

  private boolean isExistProductInCart(Product productToCheck) {
    return productInCart.stream().anyMatch(product -> product.getId() == productToCheck.getId());
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
