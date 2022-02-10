public class GroundTransport extends Transport {
    private int quantityWheels;
    private double consumption; // измеряем л/100км

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
