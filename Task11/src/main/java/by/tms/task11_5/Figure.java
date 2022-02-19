package by.tms.task11_5;

public abstract class Figure implements Calculations {

  private int sideA;
  private int sideB;
  private int sideC;

  public Figure(int sideA, int sideB, int sideC) {
    this.sideA = sideA;
    this.sideB = sideB;
    this.sideC = sideC;
  }

  public Figure(int sideA, int sideB) {
    this.sideA = sideA;
    this.sideB = sideB;
  }

  @Override
  public void getSquare() {

  }

  public int getSideA() {
    return sideA;
  }

  public int getSideB() {
    return sideB;
  }

  public int getSideC() {
    return sideC;
  }
}
