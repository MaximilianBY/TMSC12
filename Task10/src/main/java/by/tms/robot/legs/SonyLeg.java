package by.tms.robot.legs;

public class SonyLeg implements ILeg {

  private int price;

  public SonyLeg(int price) {
    this.price = price;
  }

  public SonyLeg() {
  }

  @Override
  public void step() {
    System.out.println("Делает шаг нога Sony");
  }

  @Override
  public int getPrice() {
    return price;
  }
}
