public final class PassengerAir extends AirTransport {
    private int quantityPassengers;
    private int quantityBusinessPass;
    private boolean isBusinessClass;

    public String infoPassengerAir() {
        return "вместимость пассажиров: " + getQuantityPassengers() + "\n" +
                "наличие бизнесс класса: " + (isBusinessClass ? "есть" : "нету") + "\n";
    }

    public int getQuantityBusinessPass() {
        return quantityBusinessPass;
    }

    public void setQuantityBusinessPass(int quantityBusinessPass) {
        this.quantityBusinessPass = quantityBusinessPass;
    }

    public int getQuantityPassengers() {
        return quantityPassengers;
    }

    public void setQuantityPassengers(int quantityPassengers) {
        this.quantityPassengers = quantityPassengers;
    }

    public boolean isBusinessClass() {
        return isBusinessClass;
    }

    public void setBusinessClass(boolean businessClass) {
        isBusinessClass = businessClass;
    }
}
