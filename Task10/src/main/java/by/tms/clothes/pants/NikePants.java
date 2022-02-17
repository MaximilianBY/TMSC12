package by.tms.clothes.pants;

public class NikePants implements Pants {

  @Override
  public void putOn() {
    System.out.println("Одеваем штаны Nike");
  }

  @Override
  public void takeOff() {
    System.out.println("Снимаем штаны Nike");
  }
}
