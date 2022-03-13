package by.tms.shop.module;

import java.util.Comparator;

public class Product {

  private int id;
  private String name;
  private int price;

  public Product(int id, String name, int price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  @Override
  public String toString() {
    return "ID " + id + " Name " + name + " Price " + price;
  }

  public static Comparator<Product> IDSorting = new Comparator<Product>() {
    @Override
    public int compare(Product o1, Product o2) {
      return o1.id - o2.getId();
    }
  };

  public static Comparator<Product> NameSorting = new Comparator<Product>() {
    @Override
    public int compare(Product o1, Product o2) {
      return o1.getName().compareTo(o2.getName());
    }
  };

  public static Comparator<Product> PriceAscending = new Comparator<Product>() {
    @Override
    public int compare(Product o1, Product o2) {
      return o1.price - o2.getPrice();
    }
  };

  public static Comparator<Product> PriceDescending = new Comparator<Product>() {
    @Override
    public int compare(Product o1, Product o2) {
      return o2.getPrice() - o1.price;
    }
  };

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(int price) {
    this.price = price;
  }


}
