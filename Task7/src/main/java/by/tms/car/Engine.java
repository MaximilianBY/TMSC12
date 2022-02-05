package by.tms.car;

class Engine extends Car implements Movement {
    public static final String BENZIN = "BENZIN";
    public static final String DIESEL = "DIESEL";
    private String typeFuel;
    private double tankVolume;
    private int maxSpeed;
    private double fuelConsumption;

    public Engine(String brandCar, String modelCar, String typeCar, String colorCar, String typeFuel,
                  double tankVolume, int maxSpeed, double fuelConsumption) {
        super(brandCar, modelCar, typeCar, colorCar);
        this.typeFuel = typeFuel;
        this.tankVolume = tankVolume;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public void startEngine() {
        if (tankVolume > 0) {
            System.out.println("Двигатель запущен, можно ехать!" + "\n");
            travel();
        } else {
            System.out.println("Двигатель не запущен, топливо закончилось, поездка окончена!");
        }
    }

    @Override
    public void stopEngine() {
        System.out.println("Двигатель заглушен");
        this.tankVolume = tankVolume - fuelConsumption;
        System.out.println("Время остановки закончилось, в путь!");
        startEngine();
    }

    @Override
    public void travel() {
        System.out.println(" Едем " + "\n");
    }

    @Override
    public void checkTank() {
        System.out.println("Топлива в баке осталось " + tankVolume);
    }

    public String getTypeFuel() {
        return typeFuel;
    }

    public void setTypeFuel(String typeFuel) {
        this.typeFuel = typeFuel;
    }

    public double getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(double tankVolume) {
        this.tankVolume = tankVolume;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
