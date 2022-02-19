package by.tms.task11_5;

public class Triangle extends Figure {

  public Triangle(int sideA, int sideB, int sideC) {
    super(sideA, sideB, sideC);
  }

  @Override
  public void getSquare() {
    System.out.println("Площадь треугольника равна " + getSideA() * getSideB() * getSideC());
  }

  @Override
  public int getSideA() {
    return super.getSideA();
  }

  @Override
  public int getSideB() {
    return super.getSideB();
  }

  @Override
  public int getSideC() {
    return super.getSideC();
  }
}
