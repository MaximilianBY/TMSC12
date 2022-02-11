public class GroundTransport extends Transport {
    private int quantityWheels;
    private double consumption; // измеряем л/100км

    public String infoGroundTransport() {
        return "Информация о автомобиле: " + getBrand() + "\n" +
                "количество колес: " + getQuantityWheels() + "\n" +
                "масса автомобиля: " + getWeight() + " кг" + "\n" +
                "мощность автомобиля: " + getHorsePower() + " лошадиных сил" + " или " + getkWPower() + " килоВатт" + "\n" +
                "максимальная скорость: " + getMaxSpeed() + " км/ч" + "\n" +
                "расход топлива: " + getConsumption() + " л/100км" + "\n";
    }

    public void infoTravel(double timeTravel) {
        System.out.println("За время " + timeTravel + " ч, автомобиль " + getBrand() +
                " двигаясь с максимальной скоростью " + getMaxSpeed() + " км/ч проедет " + timeTravel * getMaxSpeed() +
                " км и израсходует " + infoConsumption(timeTravel) + " литров топлива.");
    }

    private double infoConsumption(double timeTravel) {
        return timeTravel * getMaxSpeed() * (getConsumption() / 100);
    }

    public void infoLoadCapacity(double loadingWeight, double loadCapacity) {
        System.out.println("Загружаем " + loadingWeight + " т");
        System.out.println(loadCapacity >= loadingWeight ? "Грузовик загружен" : "Вам нужен грузовик побольше");
    }

    public int getQuantityWheels() {
        return quantityWheels;
    }

    public void setQuantityWheels(int quantityWheels) {
        this.quantityWheels = quantityWheels;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }
}
