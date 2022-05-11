package by.tms.model.user;

import by.tms.model.product.Product;
import java.util.Map;
import java.util.Objects;

public class User {

  private final String name;
  private String password;
  private String email;
  private String phoneNumber;

  private Map<Integer, Product> productMap;

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public User(String name, String password, String email, String phoneNumber) {
    this.name = name;
    this.password = password;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public User(String name, String password, String email, String phoneNumber,
      Map<Integer, Product> productMap) {
    this.name = name;
    this.password = password;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.productMap = productMap;
  }

  public Map<Integer, Product> getProductsFromCart() {
    return productMap;
  }

  public void addProductToCart(int idPRoduct, Product product) {
    productMap.put(idPRoduct, product);
  }

  public void clearCart() {
    productMap.clear();
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return getName().equals(user.getName()) && getPassword().equals(user.getPassword())
        && getEmail().equals(user.getEmail()) && getPhoneNumber().equals(user.getPhoneNumber())
        && getProductsFromCart().equals(user.getProductsFromCart());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getPassword(), getEmail(), getPhoneNumber(),
        getProductsFromCart());
  }
}
