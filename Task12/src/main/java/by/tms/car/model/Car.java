package by.tms.car.model;

import java.util.Random;

public class Car {

  private String brand;
  private String model;
  private int maxSpeed;
  private double price;

  public Car(String brand, String model, int maxSpeed, double price) {
    this.brand = brand;
    this.model = model;
    this.maxSpeed = maxSpeed;
    this.price = price;
  }

  public Car() {
  }

  public void startUp() {
    Random random = new Random();
    if (random.nextInt(21) % 2 == 0) {
      try {
        throw new Malfunction();
      } catch (Malfunction e) {
        System.out.println(e.message());
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Автомобиль " + getBrand() + " " + getModel() + " завелся!");
    }
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

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(int maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
