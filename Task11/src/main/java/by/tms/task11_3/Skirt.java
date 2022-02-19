package by.tms.task11_3;

public class Skirt extends Clothes implements ClothingWomens {

  public Skirt(ClothesSize size, String color, int price) {
    super(size, color, price);
  }

  @Override
  public void dressWoman() {
    System.out.println("юбка женская, размер " + getSize().euroSize + "/" + getSize().name() + "/"
        + getSize().getDescription() + ". цвет " + getColor() + ". цена " + getPrice()
        + " рублей.");
  }

  @Override
  public ClothesSize getSize() {
    return super.getSize();
  }

  @Override
  public String getColor() {
    return super.getColor();
  }

  @Override
  public int getPrice() {
    return super.getPrice();
  }
}
