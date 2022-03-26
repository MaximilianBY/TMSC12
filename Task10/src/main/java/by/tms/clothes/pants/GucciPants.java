package by.tms.clothes.pants;

public class GucciPants implements Pants {

  @Override
  public void putOn() {
    System.out.println("Одеваем штаны Gucci");
  }

  @Override
  public void takeOff() {
    System.out.println("Снимаем штаны Gucci");
  }
}
