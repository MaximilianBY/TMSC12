public final class MilitaryAir extends AirTransport {
    private boolean isCatapult;
    private int quantityRockets;

    public String infoMilitaryAir() {
        return "количество ракет: " + getQuantityRockets() + "\n" +
                "наличие катапульты: " + (isCatapult ? "есть" : "нету") + "\n";
    }

    public boolean isCatapult() {
        return isCatapult;
    }

    public void setCatapult(boolean catapult) {
        isCatapult = catapult;
    }

    public int getQuantityRockets() {
        return quantityRockets;
    }

    public void setQuantityRockets(int quantityRockets) {
        this.quantityRockets = quantityRockets;
    }

}
