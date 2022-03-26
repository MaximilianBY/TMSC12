package by.tms.task11_5;

public class Main {

  public static void main(String[] args) {
    Figure[] figures = {new Line(Type.LINE, 15, 35),
        new Rectangle(Type.RECTANGLE, 25, 65),
        new Triangle(Type.TRIANGLE, 12, 35, 43, 22)};

    for (Figure figure : figures) {
      figure.getSquare(figure.getType());
    }
  }

}
