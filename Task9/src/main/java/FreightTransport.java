public final class FreightTransport extends GroundTransport {
    private double loadCapacity; //измеряем в тоннах


    public String infoFreightTransport() {
        return "грузоподъемность: " + getLoadCapacity() + " т" + "\n";
    }


    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
