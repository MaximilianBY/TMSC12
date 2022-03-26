package by.tms.clothes.jacket;

public class GucciJacket implements Jacket {

  @Override
  public void putOn() {
    System.out.println("Одеваем куртку Gucci");
  }

  @Override
  public void takeOff() {
    System.out.println("Снимаем куртку Gucci");
  }
}
