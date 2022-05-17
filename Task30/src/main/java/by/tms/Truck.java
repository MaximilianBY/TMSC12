package by.tms;

public class Truck extends Car {

  private String typeTruck;
  private int loadCapacity;

  public Truck(String brand, String model, String typeFuel, String typeEngine, int engineCC,
      String typeTruck, int loadCapacity) {
    super(brand, model, typeFuel, typeEngine, engineCC);
    this.typeTruck = typeTruck;
    this.loadCapacity = loadCapacity;
  }

  public String getTypeTruck() {
    return typeTruck;
  }

  public void setTypeTruck(String typeTruck) {
    this.typeTruck = typeTruck;
  }

  public int getLoadCapacity() {
    return loadCapacity;
  }

  public void setLoadCapacity(int loadCapacity) {
    this.loadCapacity = loadCapacity;
  }

  @Override
  public String toString() {
    return getBrand() + "\n" + getModel() + "\n" +
        getTypeFuel() + "\n" + getTypeEngine() + "\n" + getEngineCC() + "\n" + getTypeTruck() + "\n"
        + getLoadCapacity();
  }
}
