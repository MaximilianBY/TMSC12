package by.tms.clothes.jacket;

public class DenimJacket implements Jacket {

  @Override
  public void putOn() {
    System.out.println("Одеваем куртку Denim");
  }

  @Override
  public void takeOff() {
    System.out.println("Снимаем куртку Denim");
  }
}
