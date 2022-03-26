public final class PassengerTransport extends GroundTransport {
    private String bodyType;
    private int quantityPassengers;

    public String infoPassengerTransport() {
        return "тип кузова: " + getBodyType() + "\n" +
                "вместительность пассажиров: " + getQuantityPassengers() + "\n";
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
}
