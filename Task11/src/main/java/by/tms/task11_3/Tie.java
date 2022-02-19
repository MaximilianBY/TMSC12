package by.tms.task11_3;

public class Tie extends Clothes implements ClothingMens {


  public Tie(ClothesSize size, String color, int price) {
    super(size, color, price);
  }

  @Override
  public void dressMan() {
    System.out.println(
        "галстук мужской, размер " + getSize().euroSize + "/" + getSize().name() + "/"
            + getSize().getDescription() + ". цвет " + getColor() + ". цена " + getPrice()
            + " рублей.");
  }
}
