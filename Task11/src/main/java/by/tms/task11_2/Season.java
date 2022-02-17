package by.tms.task11_2;

public interface Season {

  void getDescription();

  enum Seasons {
    DECEMBER("Декабрь"), JANUARY("Январь"), FEBRUARY("Февраль"), MARCH("Март"),
    APRIL("Апрель"), MAY("Май"), JUNE("Июнь"), JULY("Июль"),
    AUGUST("Август"), SEPTEMBER("Сентябрь"), OCTOBER("Октябрь"), NOVEMBER("Ноябрь");

    public final String name;

    private Seasons(String name) {
      this.name = name;
    }
  }
}
