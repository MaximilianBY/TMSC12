package by.tms.online_shop.model;

public class Product {

  private int id;
  private String name;
  private String model;
  private String reviews;
  private int price;
  private int currentAvailability;

  public Product(int id, String name, String model, String reviews, int price,
      int currentAvailability) {
    this.id = id;
    this.name = name;
    this.model = model;
    this.reviews = reviews;
    this.price = price;
    this.currentAvailability = currentAvailability;
  }

  public Product(String name, String model, String reviews, int price, int currentAvailability) {
    this.name = name;
    this.model = model;
    this.reviews = reviews;
    this.price = price;
    this.currentAvailability = currentAvailability;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getReviews() {
    return reviews;
  }

  public void setReviews(String reviews) {
    this.reviews = reviews;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getCurrentAvailability() {
    return currentAvailability;
  }

  public void setCurrentAvailability(int currentAvailability) {
    this.currentAvailability = currentAvailability;
  }

  @Override
  public String toString() {
    return "Product:" + "\n" +
        "id: " + id + "\n" +
        "name: " + name + "\n" +
        "model: " + model + "\n" +
        "reviews:" + reviews + "\n" +
        "price: " + price + "\n" +
        "currentAvailability: " + currentAvailability + "\n";
  }
}
