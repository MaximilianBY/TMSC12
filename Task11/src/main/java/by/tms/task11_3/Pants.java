package by.tms.task11_3;

public class Pants extends Clothes implements ClothingMens, ClothingWomens {

  public Pants(ClothesSize size, String color, int price) {
    super(size, color, price);
  }

  @Override
  public void dressMan() {
    System.out.println("штаны мужские, размер " + getSize().euroSize + "/" + getSize().name() + "/"
        + getSize().getDescription() + ". цвет " + getColor() + ". цена " + getPrice()
        + " рублей.");
  }

  @Override
  public void dressWoman() {
    System.out.println("штаны женские размер " + getSize().euroSize + "/" + getSize().name() + "/"
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
