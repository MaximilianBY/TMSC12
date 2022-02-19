package by.tms.task11_4;

public class Apricot extends Fruit {

  private double price;
  private double toPay;

  public Apricot(double weight, double price) {
    super(weight);
    this.price = price;
  }

  @Override
  public void pricePurchase() {
    toPay = getWeight() * price / 1000;
    System.out.println("С Вас " + toPay + " рублей, за " + getWeight() + " грамм абрикосов");
  }

  public double getToPay() {
    return toPay;
  }
}
