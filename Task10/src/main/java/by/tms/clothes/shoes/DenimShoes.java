package by.tms.clothes.shoes;

public class DenimShoes implements Shoes {

  @Override
  public void putOn() {
    System.out.println("Одеваем обувь Denim");
  }

  @Override
  public void takeOff() {
    System.out.println("Снимаем обувь Denim");
  }
}
