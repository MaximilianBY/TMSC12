package by.tms.spaceport;

public class SpacePort {

  public void launch(IStart iStart) {
    if (!iStart.isCheck()) {
      System.out.println("Предстартовая проверка провалена");
    } else {
      iStart.startEngine();
      iStart.start();
    }
  }

}
