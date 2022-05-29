package by.tms.model;

import java.util.Objects;

public class Product {

  private int id;
  private String brand;
  private String model;
  private String description;
  private int price;
  private String imageName;
  private int quantity;
  private int categoryID;

  public Product(int id, String brand, String model, String description, int price,
      String imageName,
      int quantity, int categoryID) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.description = description;
    this.price = price;
    this.imageName = imageName;
    this.quantity = quantity;
    this.categoryID = categoryID;
  }

  public Product(int id, String brand, String model, String description, int price,
      String imageName,
      int quantity) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.description = description;
    this.price = price;
    this.imageName = imageName;
    this.quantity = quantity;
  }

  public int getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public String getDescription() {
    return description;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getImageName() {
    return imageName;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getCategoryID() {
    return categoryID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return getId() == product.getId() && getPrice() == product.getPrice()
        && getQuantity() == product.getQuantity() && getCategoryID() == product.getCategoryID()
        && getBrand().equals(product.getBrand()) && getModel().equals(product.getModel())
        && getDescription().equals(product.getDescription()) && getImageName().equals(
        product.getImageName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getBrand(), getModel(), getDescription(), getPrice(),
        getImageName(),
        getQuantity(), getCategoryID());
  }
}
