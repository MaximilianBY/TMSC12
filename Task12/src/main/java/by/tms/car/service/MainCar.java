package by.tms.car.service;

import by.tms.car.model.Car;

public class MainCar {

  public static void main(String[] args) {
    Car alfa = new Car("Alfa Romeo", "156", 240, 3000);
    Car bmw = new Car("BMW", "5 E60", 260, 10000);
    Car audi = new Car("Audi", "A6 C7", 260, 20000);

    alfa.startUp();
    bmw.startUp();
    audi.startUp();
  }
}
