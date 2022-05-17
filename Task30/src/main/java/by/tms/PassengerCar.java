package by.tms;

public class PassengerCar extends Car {

  private String bodyType;
  private int quantityDoors;
  private String color;

  public PassengerCar(String brand, String model, String typeFuel, String typeEngine, int engineCC,
      String bodyType, int quantityDoors, String color) {
    super(brand, model, typeFuel, typeEngine, engineCC);
    this.bodyType = bodyType;
    this.quantityDoors = quantityDoors;
    this.color = color;
  }

  public String getBodyType() {
    return bodyType;
  }

  public void setBodyType(String bodyType) {
    this.bodyType = bodyType;
  }

  public int getQuantityDoors() {
    return quantityDoors;
  }

  public void setQuantityDoors(int quantityDoors) {
    this.quantityDoors = quantityDoors;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return getBrand() + "\n" + getModel() + "\n" +
        getTypeFuel() + "\n" + getTypeEngine() + "\n" + getEngineCC() + "\n" + getBodyType() + "\n"
        +
        getQuantityDoors() + "\n" + getColor();
  }
}
