package by.tms.car;
/*
Логика получилась большая на мой взгляд, но как уменьшить пока не понимаюи стоит ли.
 */

class Main {
  public static void main(String[] args) {
    Car car1 = new Car("Alfa Romeo", "156", "Family Sedan", Car.DIESEL, 63, 200, 4.6);
    Car car2 = new Car("BMW", "M3 E46", "Sport coupe", Car.BENZIN, 70, 280, 12);
    infoTravel(car1, "Минск", "Катания", 3200);
    infoTravel(car2, "Минск", "Катания", 3200);
  }

  public static void infoTravel(Car car, String fromCity, String toCity, int distance) {
    System.out.println(
        "\n"
            + "Отправляемся из "
            + fromCity
            + " в "
            + toCity
            + ", расстояние составляет "
            + distance
            + " километров"
            + "\n");
    int traveledDistance =
        0; // счетчик для автомобиля, сколько км он проехал, задумывался под другое, но в целом и
           // тут сгодился
    int refuelingLimit =
        (int) Math.round(distance / car.getTankVolume() / car.getFuelConsumption() * 100);
    // в 20 строке высчитал сколько потребуется дозаправок для преодоления заданного расстояния
    double tankLimit =
        car.getTankVolume(); // сюда записал инфу о объеме бака, для последующих дозаправок
    for (int i = 0; i < distance; i++) {
      if (car.getTankVolume() > 0) { // проверяем в баке есть топливо или нет
        if (i % 100 == 0) {
          car.startEngine();
          car.travel();
          car.stopEngine();
          car.setTankVolume(car.getTankVolume() - car.getFuelConsumption());
          traveledDistance += 100;
        }
      } else if (car.getTankVolume() <= 0 && refuelingLimit > 0) {
        System.out.println("Бак пуст! Необходимо дозаправиться!" + "\n"); // дозаправка
        car.refillBank();
        System.out.print(tankLimit + "л" + "\n");
        car.setTankVolume(tankLimit);
        refuelingLimit--;
      }
    }
    //        System.out.println("Поездка окончена, вы приехали в пункт назначения!" + "\n");
    System.out.println(
        "\n"
            + car.getBrand()
            + " "
            + car.getModel()
            + " "
            + car.getType()
            + " проехала "
            + traveledDistance
            + " км");
  }
}
