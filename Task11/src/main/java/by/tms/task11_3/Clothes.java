package by.tms.task11_3;

public abstract class Clothes {

  private ClothesSize size;
  private String color;
  private int price;

  public Clothes(ClothesSize size, String color, int price) {
    this.size = size;
    this.color = color;
    this.price = price;
  }

  public ClothesSize getSize() {
    return size;
  }

  public String getColor() {
    return color;
  }

  public int getPrice() {
    return price;
  }
}
