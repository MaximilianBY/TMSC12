package by.tms.car.model;

import java.io.Serializable;

public class Car implements Serializable {

  private String brand;
  public Engine engine;
  public TankFuel tankFuel;
  private int maxSpeed;
  private int price;

  public Car(String brand, Engine engine, TankFuel tankFuel, int maxSpeed, int price) {
    this.brand = brand;
    this.engine = engine;
    this.tankFuel = tankFuel;
    this.maxSpeed = maxSpeed;
    this.price = price;
  }

  public static class Engine implements Serializable {

    private String architectType;
    transient private int numOfPiston;

    public Engine(String architectType, int numOfPiston) {
      this.architectType = architectType;
      this.numOfPiston = numOfPiston;
    }

    public String getArchitectType() {
      return architectType;
    }

    public int getNumOfPiston() {
      return numOfPiston;
    }
  }

  public static class TankFuel implements Serializable {

    private String typeFuel;
    private int capacityTank;

    public TankFuel(String typeFuel, int capacityTank) {
      this.typeFuel = typeFuel;
      this.capacityTank = capacityTank;
    }

    public String getTypeFuel() {
      return typeFuel;
    }

    public int getCapacityTank() {
      return capacityTank;
    }
  }

  @Override
  public String toString() {
    return "Это автомобиль " +
        "марки " + brand + ". " + "\n" +
        "тип двигателя " + engine.getArchitectType() + "\n" +
        "кол-во цилиндров " + engine.getNumOfPiston() + "\n" +
        "тип топлива " + tankFuel.getTypeFuel() + "\n" +
        "объем бака " + tankFuel.getCapacityTank() + " литра\n" +
        "Максимальная скорость составляет " + maxSpeed + " км/ч. " + "\n" +
        "Цена " + price + " $.";
  }
}