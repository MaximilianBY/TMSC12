package by.tms.task11_2;

public class Summer implements Season {

  private int temperature;

  public Summer(int temperature) {
    this.temperature = temperature;
  }

  @Override
  public void getDescription() {
    System.out.println("Я люблю лето, потому что это " + Constants.HOT_TIME
        + " Средняя температура летом составляет " + temperature + " градусов");
  }
}
