public final class FreightTransport extends GroundTransport {
    private double loadCapacity; //измеряем в тоннах
    private double kWPower;


    public String info() {
        return "Информация о автомобиле: " + getBrand() + "\n" +
                "количество колес: " + getQuantityWheels() + "\n" +
                "масса автомобиля: " + getWeight() + " кг" + "\n" +
                "мощность автомобиля: " + getHorsePower() + " лошадиных сил" + " или " + getkWPower() + " килоВатт" + "\n" +
                "максимальная скорость: " + getMaxSpeed() + " км/ч" + "\n" +
                "расход топлива: " + getConsumption() + " л/100км" + "\n" +
                "грузоподъемность: " + getLoadCapacity() + " т";
    }

    public void infoLoadCapacity(double loadingWeight) {
        System.out.println("Загружаем " + loadingWeight + " т");
        System.out.println(loadCapacity >= loadingWeight ? "Грузовик загружен" : "Вам нужен грузовик побольше");
    }

    public double getkWPower() {
        return kWPower;
    }

    public void setkWPower(double kWPower) {
        this.kWPower = kWPower * 0.74;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public int getQuantityWheels() {
        return super.getQuantityWheels();
    }

    @Override
    public void setQuantityWheels(int quantityWheels) {
        super.setQuantityWheels(quantityWheels);
    }

    @Override
    public double getConsumption() {
        return super.getConsumption();
    }

    @Override
    public void setConsumption(double consumption) {
        super.setConsumption(consumption);
    }

    @Override
    public int getHorsePower() {
        return super.getHorsePower();
    }

    @Override
    public void setHorsePower(int horsePower) {
        super.setHorsePower(horsePower);
    }

    @Override
    public int getMaxSpeed() {
        return super.getMaxSpeed();
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        super.setMaxSpeed(maxSpeed);
    }

    @Override
    public int getWeight() {
        return super.getWeight();
    }

    @Override
    public void setWeight(int weight) {
        super.setWeight(weight);
    }

    @Override
    public String getBrand() {
        return super.getBrand();
    }

    @Override
    public void setBrand(String brand) {
        super.setBrand(brand);
    }
}
