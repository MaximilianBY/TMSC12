package by.tms.task11_5;

public class Main {

  public static void main(String[] args) {
    Figure[] figures = {new Line(15, 35), new Rectangle(25, 65), new Triangle(12, 35, 43)};

    for (Figure figure : figures) {
      figure.getSquare();
    }
  }

}
