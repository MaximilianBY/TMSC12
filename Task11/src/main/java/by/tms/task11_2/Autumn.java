package by.tms.task11_2;

public class Autumn implements Season {

  private String month;
  private int temperature;

  public Autumn(String month, int temperature) {
    this.month = month;
    this.temperature = temperature;
  }

  @Override
  public void getDescription() {
    if (month.equals(Type.SEPTEMBER.name)) {
      System.out.println("Я люблю осень, потому что это " + Constants.HOT_TIME
          + " Средняя температура осенью составляет " + temperature + " градусов");
    } else {
      System.out.println("Я люблю осень, потому что это " + Constants.COLD_TIME
          + " Средняя температура осенью составляет " + temperature + " градусов");
    }
  }
}
