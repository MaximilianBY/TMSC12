package by.tms.car.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Car implements Serializable {

  private static final String jsonFile = "C:\\Users\\hitch\\AppData\\Roaming\\JetBrains\\IdeaIC2021.3\\scratches\\scratch.json";
  private String brand;
  private String model;
  private Engine engine;
  private TankFuel tankFuel;
  private int maxSpeed;
  private int price;
  private String someString;

  public Car(String brand, Engine engine, TankFuel tankFuel, int maxSpeed,
      int price) {
    this.brand = brand;
    this.engine = engine;
    this.tankFuel = tankFuel;
    this.maxSpeed = maxSpeed;
    this.price = price;
  }

  @JsonCreator
  public Car(
      @JsonProperty("brand_name") String brand,
      @JsonProperty("model_name") String model,
      @JsonProperty("max_speed") int maxSpeed,
      @JsonProperty("price") int price,
      @JsonProperty("str") String someString
  ) {
    this.brand = brand;
    this.model = model;
    this.maxSpeed = maxSpeed;
    this.price = price;
    this.someString = someString;
  }

  public static Car readJsonFile() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(new File(jsonFile), Car.class);
  }

  public String printJsonFile() {
    return "Info from Json File: " + "\n" +
        "Brand: " + brand + "\n" +
        "Model: " + model + "\n" +
        "Max speed: " + maxSpeed + "\n" +
        "Price: " + price + "\n" +
        "Some string: " + someString;
  }

  public static class Engine implements Serializable {

    private String architectType;
    private transient int numOfPiston;

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