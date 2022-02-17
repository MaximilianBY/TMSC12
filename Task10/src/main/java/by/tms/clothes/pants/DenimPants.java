package by.tms.clothes.pants;

public class DenimPants implements Pants {

  @Override
  public void putOn() {
    System.out.println("Одеваем штаны Denim");
  }

  @Override
  public void takeOff() {
    System.out.println("Снимаем штаны Denim");
  }
}
