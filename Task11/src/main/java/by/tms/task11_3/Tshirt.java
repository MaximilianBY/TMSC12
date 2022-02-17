package by.tms.task11_3;

public class Tshirt extends Clothes implements ClothingMens, ClothingWomens {

  public Tshirt(ClothesSize size, String color, int price) {
    super(size, color, price);
  }

  @Override
  public void dressMan() {
    System.out.println(
        "футболка мужская, размер " + getSize().euroSize + "/" + getSize().name() + "/"
            + getSize().getDescription() + ". цвет " + getColor() + ". цена " + getPrice()
            + " рублей.");
  }

  @Override
  public void dressWoman() {
    System.out.println(
        "футболка женская, размер " + getSize().euroSize + "/" + getSize().name() + "/"
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
