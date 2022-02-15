package by.tms.clothes.jacket;

public class NikeJacket implements Jacket {

  @Override
  public void putOn() {
    System.out.println("Одеваем куртку Nike");
  }

  @Override
  public void takeOff() {
    System.out.println("Снимаем куртку Nike");
  }
}
