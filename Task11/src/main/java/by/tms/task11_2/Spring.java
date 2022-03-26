package by.tms.task11_2;

public class Spring implements Season {

  private String month;
  private int temperature;

  public Spring(String month, int temperature) {
    this.month = month;
    this.temperature = temperature;
  }

  @Override
  public void getDescription() {
    if (month.equals(Type.MARCH.name)) {
      System.out.println("Я люблю весну, потому что это " + Constants.COLD_TIME
          + " Средняя температура весной составляет " + temperature + " градусов");
    } else {
      System.out.println("Я люблю весну, потому что это " + Constants.HOT_TIME
          + " Средняя температура весной составляет " + temperature + " градусов");
    }
  }
}
