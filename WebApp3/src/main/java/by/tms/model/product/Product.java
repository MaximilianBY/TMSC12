package by.tms.model.product;

import java.util.Objects;

public class Product {

  private int id;
  private String user_id;
  private int order_id;
  private String brand;
  private String model;
  private String type;
  private String description;
  private int price;
  private String imageName;
  private int quantity;

  public Product(int id, int order_id, String brand, String model, String type,
      String description, int price, int quantity, String imageName) {
    this.id = id;
    this.order_id = order_id;
    this.brand = brand;
    this.model = model;
    this.type = type;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
    this.imageName = imageName;
  }

  public Product(int id, String brand, String model, String type, String description, int price,
      String imageName, int quantity) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.type = type;
    this.description = description;
    this.price = price;
    this.imageName = imageName;
    this.quantity = quantity;
  }

  public Product(String brand, String model, String type, String description, int price,
      String imageName, int quantity) {
    this.brand = brand;
    this.model = model;
    this.type = type;
    this.description = description;
    this.price = price;
    this.imageName = imageName;
    this.quantity = quantity;
  }

  public int getId() {
    return id;
  }

  public String getUser_id() {
    return user_id;
  }

  public int getOrder_id() {
    return order_id;
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public String getType() {
    return type;
  }

  public String getDescription() {
    return description;
  }

  public int getPrice() {
    return price;
  }

  public String getImageName() {
    return imageName;
  }

  public int getQuantity() {
    return quantity;
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
    return getId() == product.getId() && getUser_id() == product.getUser_id()
        && getOrder_id() == product.getOrder_id() && getPrice() == product.getPrice()
        && getQuantity() == product.getQuantity() && getBrand().equals(product.getBrand())
        && getModel().equals(product.getModel()) && getType().equals(product.getType())
        && getDescription().equals(product.getDescription()) && getImageName().equals(
        product.getImageName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getUser_id(), getOrder_id(), getBrand(), getModel(), getType(),
        getDescription(), getPrice(), getImageName(), getQuantity());
  }
}
