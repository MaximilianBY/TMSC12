package by.tms.task11_1;

public class Trumpet implements Instrument {

  private int diameter;

  public Trumpet(int diameter) {
    this.diameter = diameter;
  }

  @Override
  public void play() {
    System.out.println("Играет труба диаметром " + diameter);
  }
}
