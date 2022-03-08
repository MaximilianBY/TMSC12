package by.tms.car.service;

import by.tms.car.constant.Constants;
import by.tms.car.model.Car;
import by.tms.car.model.Car.Engine;
import by.tms.car.model.Car.TankFuel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Car alfa = new Car("AlfaRomeo", new Engine(Constants.INLINE_TYPE_ENGINE, 4),
        new TankFuel(Constants.BENZIN, 64), 220, 5000);

    ObjectOutputStream objectOutputStream = new ObjectOutputStream(
        new FileOutputStream("Task14/src/main/resources/Alfa.dat"));
    objectOutputStream.writeObject(alfa);
    objectOutputStream.close();

    ObjectInputStream objectInputStream = new ObjectInputStream(
        new FileInputStream("Task14/src/main/resources/Alfa.dat"));
    Object object = objectInputStream.readObject();
    objectInputStream.close();

    Car someCar = (Car) object;
    System.out.println(someCar);
  }
}
