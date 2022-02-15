package by.tms.clothes.shoes;

public class NikeShoes implements Shoes {

  @Override
  public void putOn() {
    System.out.println("Одеваем обувь Nike");
  }

  @Override
  public void takeOff() {
    System.out.println("Снимаем обувь Nike");
  }
}
