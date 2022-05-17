package by.tms;

public abstract class Car implements Cloneable {

  private String brand;
  private String model;
  private String typeFuel;
  private String typeEngine;
  private int engineCC;

  public Car() {
  }

  public Car(String brand, String model, String typeFuel, String typeEngine, int engineCC) {
    this.brand = brand;
    this.model = model;
    this.typeFuel = typeFuel;
    this.typeEngine = typeEngine;
    this.engineCC = engineCC;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getTypeFuel() {
    return typeFuel;
  }

  public void setTypeFuel(String typeFuel) {
    this.typeFuel = typeFuel;
  }

  public String getTypeEngine() {
    return typeEngine;
  }

  public void setTypeEngine(String typeEngine) {
    this.typeEngine = typeEngine;
  }

  public int getEngineCC() {
    return engineCC;
  }

  public void setEngineCC(int engineCC) {
    this.engineCC = engineCC;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
