package by.tms;

import java.util.Objects;
import java.util.Optional;

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

  public PassengerCar(PassengerCar pc) {
    super(pc);
    if (Optional.ofNullable(pc).isPresent()) {
      this.bodyType = pc.getBodyType();
      this.quantityDoors = pc.getQuantityDoors();
      this.color = pc.getColor();
    }
  }

  public String getBodyType() {
    return bodyType;
  }

  public int getQuantityDoors() {
    return quantityDoors;
  }

  public String getColor() {
    return color;
  }

  @Override
  public String toString() {
    return getBrand() + "\n" + getModel() + "\n" +
        getTypeFuel() + "\n" + getTypeEngine() + "\n" + getEngineCC() + "\n" + getBodyType() + "\n"
        +
        getQuantityDoors() + "\n" + getColor();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof PassengerCar) || !super.equals(o)) {
      return false;
    }
    PassengerCar car = (PassengerCar) o;
    return Objects.equals(car.getBodyType(), bodyType) && Objects.equals(car.getColor(), color)
        && car.getQuantityDoors() == quantityDoors;
  }

  @Override
  public Car clone() {
    return new PassengerCar(this);
  }
}
