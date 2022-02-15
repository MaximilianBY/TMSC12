package by.tms.clothes.shoes;

public class GucciShoes implements Shoes {

  @Override
  public void putOn() {
    System.out.println("Одеваем обувь Gucci");
  }

  @Override
  public void takeOff() {
    System.out.println("Снимаем обувь Gucci");
  }
}
