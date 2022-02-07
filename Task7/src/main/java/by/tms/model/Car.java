package by.tms.model;
/*

 */

class Car implements Movement {
    public static final String BENZIN = "BENZIN";
    public static final String DIESEL = "DIESEL";
    private String brand;
    private String model;
    private String type;
    private String typeFuel;
    private double tankVolume;
    private int maxSpeed;
    private double fuelConsumption;

    public Car(String brand, String model, String type, String typeFuel, double tankVolume, int maxSpeed, double fuelConsumption) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.typeFuel = typeFuel;
        this.tankVolume = tankVolume;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public void startEngine() {
        if (tankVolume > 0) {
            System.out.println("Двигатель запущен, можно ехать!" + "\n");
        } else {
            System.out.println("Двигатель не запущен, топливо закончилось, поездка окончена!");
        }
    }

    @Override
    public void stopEngine() {
        System.out.println("Время остановки, двигатель заглушен!" + "\n");
        System.out.println("Время остановки закончилось, в путь!" + "\n");
    }

    @Override
    public void travel() {
        System.out.println("Едем" + "\n");
    }

    @Override
    public void refillBank() {
        System.out.print("Заправляем полный бак! ");
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
