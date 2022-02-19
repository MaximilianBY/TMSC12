package by.tms.task11_5;

public class Rectangle extends Figure {

  public Rectangle(int sideA, int sideB) {
    super(sideA, sideB);
  }

  @Override
  public void getSquare() {
    System.out.println("Площадь прямоугольника равна " + getSideA() * getSideB());
  }

  @Override
  public int getSideA() {
    return super.getSideA();
  }

  @Override
  public int getSideB() {
    return super.getSideB();
  }
}
