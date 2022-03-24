package by.tms.task11_5;

public abstract class Figure {

  private Type type;
  private int sideA;
  private int sideB;
  private int sideC;
  private int radius;

  public Figure(Type type, int sideA, int sideB, int sideC, int radius) {
    this.type = type;
    this.sideA = sideA;
    this.sideB = sideB;
    this.sideC = sideC;
    this.radius = radius;
  }

  public Figure(Type type, int sideA, int sideB) {
    this.type = type;
    this.sideA = sideA;
    this.sideB = sideB;
  }

  public void getSquare(Type type) {
    if (type == Type.RECTANGLE) {
      System.out.println("Площадь прямоугольника равна " + sideA * sideB);
    } else if (type == Type.TRIANGLE) {
      System.out.println("Площадь треугольника равна " + radius * (sideA + sideB + sideC) / 2);
    }
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }
}
