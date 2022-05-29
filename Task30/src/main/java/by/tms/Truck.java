package by.tms;

import java.util.Objects;
import java.util.Optional;

public class Truck extends Car {

  private String typeTruck;
  private int loadCapacity;

  public Truck(String brand, String model, String typeFuel, String typeEngine, int engineCC,
      String typeTruck, int loadCapacity) {
    super(brand, model, typeFuel, typeEngine, engineCC);
    this.typeTruck = typeTruck;
    this.loadCapacity = loadCapacity;
  }

  public Truck(Truck tr) {
    super(tr);
    if (Optional.ofNullable(tr).isPresent()) {
      this.typeTruck = tr.getTypeTruck();
      this.loadCapacity = tr.getLoadCapacity();
    }
  }

  public String getTypeTruck() {
    return typeTruck;
  }

  public int getLoadCapacity() {
    return loadCapacity;
  }

  @Override
  public String toString() {
    return getBrand() + "\n" + getModel() + "\n" +
        getTypeFuel() + "\n" + getTypeEngine() + "\n" + getEngineCC() + "\n" + getTypeTruck() + "\n"
        + getLoadCapacity();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Truck) || !super.equals(o)) {
      return false;
    }
    Truck tr = (Truck) o;
    return Objects.equals(tr.getTypeTruck(), typeTruck) && tr.getLoadCapacity() == loadCapacity;
  }

  @Override
  public Car clone() {
    return new Truck(this);
  }
}
