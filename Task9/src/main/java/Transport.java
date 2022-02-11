public class Transport {
    private int horsePower; //измеряем в лошадиных силах
    private int maxSpeed; //км/ч
    private int weight; //измеряем в кг
    private String brand;
    private double kWPower;

    public double getkWPower() {
        return kWPower;
    }

    public void setkWPower(double kWPower) {
        this.kWPower = kWPower * 0.74;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
