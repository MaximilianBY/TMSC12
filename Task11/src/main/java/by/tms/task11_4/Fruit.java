package by.tms.task11_4;

public abstract class Fruit {

  private double price;
  private double weight;
  private double toPay;

  public Fruit(double weight, double price) {
    this.weight = weight;
    this.price = price;
  }

  public final void printManufacturerInfo() {
    System.out.print("Made in Belarus");
  }

  public double getWeight() {
    return weight;
  }

  public double getToPay() {
    return toPay = getWeight() * price / 1000;
  }
}
