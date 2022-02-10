public final class PassengerTransport extends GroundTransport {
    private String bodyType;
    private int quantityPassengers;
    private double kWPower;

    public String info() {
        return "Информация о автомобиле: " + getBrand() + "\n" +
                "тип кузова: " + getBodyType() + "\n" +
                "количество колес: " + getQuantityWheels() + "\n" +
                "масса автомобиля: " + getWeight() + " кг" + "\n" +
                "мощность автомобиля: " + getHorsePower() + " лошадиных сил" + " или " + getkWPower() + " килоВатт" + "\n" +
                "максимальная скорость: " + getMaxSpeed() + " км/ч" + "\n" +
                "расход топлива: " + getConsumption() + " л/100км" + "\n" +
                "вместительность пассажиров: " + getQuantityPassengers();
    }

    public void infoTravel(double timeTravel) {
        System.out.println("За время " + timeTravel + " ч, автомобиль " + getBrand() +
                " двигаясь с максимальной скоростью " + getMaxSpeed() + " км/ч проедет " + timeTravel * getMaxSpeed() +
                " км и израсходует " + infoConsumption(timeTravel) + " литров топлива.");
    }

    private double infoConsumption(double timeTravel) {
        return timeTravel * getMaxSpeed() * (getConsumption() / 100);
    }

    public double getkWPower() {
        return kWPower;
    }

    public void setkWPower(double kWPower) {
        this.kWPower = kWPower * 0.74;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getQuantityPassengers() {
        return quantityPassengers;
    }

    public void setQuantityPassengers(int quantityPassengers) {
        this.quantityPassengers = quantityPassengers;
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
}
