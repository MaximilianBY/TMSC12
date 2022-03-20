package by.tms.car.model;

public class Car {

  private String rgstryNumber;
  private Integer yearManufacturing;

  public Car(String rgstryNumber, Integer yearManufacturing) {
    this.rgstryNumber = rgstryNumber;
    this.yearManufacturing = yearManufacturing;
  }

  public String getRgstryNumber() {
    return rgstryNumber;
  }

  public Integer getYearManufacturing() {
    return yearManufacturing;
  }

  @Override
  public String toString() {
    return "Машина с госномером: " + rgstryNumber + ", год выпуска: " + yearManufacturing;
  }
}
