package by.tms.model.user;

import by.tms.model.product.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

  private final String name;
  private String password;
  private String email;
  private String phoneNumber;

  private List<Product> productListFromBasket = new ArrayList<>();

  public User(String name, String password, String email, String phoneNumber) {
    this.name = name;
    this.password = password;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public User(String name, String password, String email, String phoneNumber,
      List<Product> productListFromBasket) {
    this.name = name;
    this.password = password;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.productListFromBasket = productListFromBasket;
  }

  public List<Product> getProductListFromBasket() {
    return productListFromBasket;
  }

  public void addProductToBasketList(Product product) {
    productListFromBasket.add(product);
  }

  public void clearBasketList() {
    productListFromBasket.clear();
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
        && getProductListFromBasket().equals(user.getProductListFromBasket());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getPassword(), getEmail(), getPhoneNumber(),
        getProductListFromBasket());
  }
}
