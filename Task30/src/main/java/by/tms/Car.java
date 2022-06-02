package by.tms;

import java.util.Objects;
import java.util.Optional;

public abstract class Car {

  private String brand;
  private String model;
  private String typeFuel;
  private String typeEngine;
  private int engineCC;

  public Car(String brand, String model, String typeFuel, String typeEngine, int engineCC) {
    this.brand = brand;
    this.model = model;
    this.typeFuel = typeFuel;
    this.typeEngine = typeEngine;
    this.engineCC = engineCC;
  }

  public Car(Car car) {
    if (Optional.ofNullable(car).isPresent()) {
      this.brand = car.getBrand();
      this.model = car.getModel();
      this.typeFuel = car.getTypeFuel();
      this.typeEngine = car.getTypeEngine();
      this.engineCC = car.getEngineCC();
    }
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public String getTypeFuel() {
    return typeFuel;
  }

  public String getTypeEngine() {
    return typeEngine;
  }

  public int getEngineCC() {
    return engineCC;
  }

  public abstract Car clone();

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Car)) {
      return false;
    }
    Car car2 = (Car) o;
    return car2.getEngineCC() == engineCC && Objects.equals(car2.getBrand(), brand)
        && Objects.equals(
        car2.getModel(), model) && Objects.equals(car2.getTypeFuel(), typeFuel)
        && Objects.equals(car2.getTypeEngine(), typeEngine);
  }
}
