package by.tms.task11_4;

public abstract class Fruit {

  private double weight;

  public Fruit(double weight) {
    this.weight = weight;
  }

  public final void printManufacturerInfo() {
    System.out.print("Made in Belarus");
  }

  public abstract void pricePurchase();

  public double getWeight() {
    return weight;
  }
}
