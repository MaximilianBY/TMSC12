package by.tms.car.service;

import static by.tms.car.utils.Constants.BENZIN;
import static by.tms.car.utils.Constants.INLINE_TYPE_ENGINE;

import by.tms.car.model.Car;
import by.tms.car.model.Car.Engine;
import by.tms.car.model.Car.TankFuel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

  public static void main(String[] args) {
    Car alfa = new Car("AlfaRomeo", new Engine(INLINE_TYPE_ENGINE, 4),
        new TankFuel(BENZIN, 64), 220, 5000);
    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
        new FileOutputStream("Task14/src/main/resources/Alfa.dat"));
        ObjectInputStream objectInputStream = new ObjectInputStream(
            new FileInputStream("Task14/src/main/resources/Alfa.dat"))) {

      objectOutputStream.writeObject(alfa);
      objectOutputStream.close();

      Car someCar = (Car) objectInputStream.readObject();
      objectInputStream.close();

      System.out.println(someCar);
    } catch (ClassCastException e) { //у меня есть вопросы по этим кэтчам, они не работают.
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
//    try {
//      System.out.println(Car.readJsonFile().printJsonFile());
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
  }
}
