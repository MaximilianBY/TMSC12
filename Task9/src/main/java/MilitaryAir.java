public final class MilitaryAir extends AirTransport {
    private boolean isCatapult;
    private int quantityRockets;
    private double kWPower;

    public String info() {
        return "Информация о воздушном судне: " + getBrand() + "\n" +
                "масса воздушного судна: " + getWeight() + " кг" + "\n" +
                "мощность мощность воздушного судна: " + getHorsePower() + " лошадиных сил" + " или " + getkWPower() + " килоВатт" + "\n" +
                "максимальная скорость: " + getMaxSpeed() + " км/ч" + "\n" +
                "размах крыльев: " + getWingspan() + " метров" + "\n" +
                "Минимальная длина взлётно-посадочной полосы для взлёта: " + getMinRunLengthTakeoff() + " метров" + "\n" +
                "количество ракет: " + getQuantityRockets() + "\n" +
                "наличие катапульты: " + (isCatapult ? "есть" : "нету");
    }

    public void infoRocketLaunch(int missile) {
        System.out.println(quantityRockets >= missile ? "Ракета пошла!" : "Боеприпасы отсутствуют!");
    }

    public void ejection() {
        System.out.println(isCatapult ? "Катапультирование прошло успешно" : "У вас нет такой системы");
    }

    public double getkWPower() {
        return kWPower;
    }

    public void setkWPower(double kWPower) {
        this.kWPower = kWPower * 0.74;
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

    @Override
    public int getWingspan() {
        return super.getWingspan();
    }

    @Override
    public void setWingspan(int wingspan) {
        super.setWingspan(wingspan);
    }

    @Override
    public int getMinRunLengthTakeoff() {
        return super.getMinRunLengthTakeoff();
    }

    @Override
    public void setMinRunLengthTakeoff(int minRunLengthTakeoff) {
        super.setMinRunLengthTakeoff(minRunLengthTakeoff);
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
