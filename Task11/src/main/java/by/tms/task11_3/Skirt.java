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
}
