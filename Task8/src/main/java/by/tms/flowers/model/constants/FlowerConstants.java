package by.tms.flowers.model.constants;

public class FlowerConstants {

  public static final String ROSE = "Роза";
  public static final String TULIP = "Тюльпан";
  public static final String ASTER = "Астра";
  public static final String HERBERA = "Гербера";
  public static final double PRICE_ROSE = 4.5;
  public static final double PRICE_TULIP = 2.7;
  public static final double PRICE_ASTER = 3.1;
  public static final double PRICE_HERBERA = 1.9;

  private FlowerConstants() {
    throw new java.lang.UnsupportedOperationException(
        "This is a utility class and cannot be instantiated");
  }

  public static final void greetings() {
    System.out.println("Из каких цветов собрать Вам букет?:" + "\n" +
        "1. Роза " + FlowerConstants.PRICE_ROSE + " цена за шт." + "\n" +
        "2. Тюльпан " + FlowerConstants.PRICE_TULIP + " цена за шт." + "\n" +
        "3. Астра " + FlowerConstants.PRICE_ASTER + " цена за шт." + "\n" +
        "4. Гербера " + FlowerConstants.PRICE_HERBERA + " цена за шт." + "\n" +
        "5. Если Выбор окончен");
  }
}
