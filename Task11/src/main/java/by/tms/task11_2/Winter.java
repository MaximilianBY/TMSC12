package by.tms.task11_2;

public class Winter implements Season {

  private int temperature;

  public Winter(int temperature) {
    this.temperature = temperature;
  }

  @Override
  public void getDescription() {
    System.out.println("Я люблю зиму, потому что это " + Constants.COLD_TIME
        + " Средняя температура зимой составляет " + temperature + " градусов");
  }
}
