package by.tms.model.user;

import by.tms.model.product.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

  private String name;
  private String password;

  private List<Product> productListFromBasket = new ArrayList<>();

  public User(String name, String password) {
    this.name = name;
    this.password = password;
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

  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
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
        && getProductListFromBasket().equals(user.getProductListFromBasket());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getPassword(), getProductListFromBasket());
  }
}
