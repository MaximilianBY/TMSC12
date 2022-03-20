package by.tms.car.main;

import by.tms.car.model.Car;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Car> cars = Arrays.asList(
        new Car("AA1111BX", 2007),
        new Car("AK5555IT", 2010),
        new Car(null, 2012),
        new Car("", 2015),
        new Car("AI3838PP", 2017));

    cars.stream()
        .filter(car -> car.getRgstryNumber() != null && !car.getRgstryNumber().isEmpty()
            && !car.getRgstryNumber().isBlank() && car.getYearManufacturing() > 2010)
        .forEach(car -> System.out.println(car));
  }
}
