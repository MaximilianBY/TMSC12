package by.tms.car;
/*
Логика получилась большая на мой взгляд, но как уменьшить пока не понимаюи стоит ли.
 */

class Main {
    public static void main(String[] args) {
        Car car1 = new Engine("Alfa Romeo", "156", "Family Sedan", "Blue",
                Engine.DIESEL, 63, 200, 4.6);
        Car car2 = new Engine("BMW", "M3 E46", "Sport coupe", "Silver",
                Engine.BENZIN, 70, 280, 12);
        infoTravel((Engine) car1, "Минск", "Катания", 3200);
        infoTravel((Engine) car2, "Минск", "Катания", 3200);
    }

    public static void infoTravel(Engine car, String fromCity, String toCity, int distance) {
        System.out.println("\n" + "Отправляемся из " + fromCity + " в " + toCity + ", расстояние составляет " +
                distance + " километров" + "\n");
        int traveledDistance = 0; //счетчик для автомобиля, сколько км он проехал, задумывался под другое, но в целом и тут сгодился
        int refuelingLimit = (int) Math.round(distance / car.getTankVolume() / car.getFuelConsumption() * 100);
        //в 20 строке высчитал сколько потребуется дозаправок для преодоления заданного расстояния
        double tankLimit = car.getTankVolume(); // сюда записал инфу о объеме бака, для последующих дозаправок
        car.startEngine();
        for (int i = 0; i < distance; i++) {
            if (car.getTankVolume() > 0) { //проверяем в баке есть топливо или нет
                if (i % 100 == 0) {
                    traveledDistance += 100;
                    System.out.println("Время остановки!");
                    car.stopEngine();
                }
            } else if (car.getTankVolume() <= 0 && refuelingLimit > 0) { //дозаправка
                System.out.println("\n" + "Заправляем полный бак! " + tankLimit + "л" + "\n");
                car.setTankVolume(tankLimit);
                refuelingLimit--;
                car.startEngine();
            }

        }
        System.out.println("Поездка окончена, вы приехали в пункт назначения!" + "\n");
        System.out.println("\n" + car.getBrandCar() + " " + car.getModelCar() + " " +
                car.getTypeCar() + " проехала " + traveledDistance + " км");
    }
}
