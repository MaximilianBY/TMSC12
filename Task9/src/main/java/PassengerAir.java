public final class PassengerAir extends AirTransport {
    private int quantityPassengers;
    private int quantityBusinessPass;
    private boolean isBusinessClass;
    private double kWPower;

    public String info() {
        return "Информация о воздушном судне: " + getBrand() + "\n" +
                "масса воздушного судна: " + getWeight() + " кг" + "\n" +
                "мощность воздушного судна: " + getHorsePower() + " лошадиных сил" + " или " + getkWPower() + " килоВатт" + "\n" +
                "максимальная скорость: " + getMaxSpeed() + " км/ч" + "\n" +
                "размах крыльев: " + getWingspan() + " метров" + "\n" +
                "Минимальная длина взлётно-посадочной полосы для взлёта: " + getMinRunLengthTakeoff() + " метров" + "\n" +
                "вместимость пассажиров: " + getQuantityPassengers() + "\n" +
                "наличие бизнесс класса: " + (isBusinessClass ? "есть" : "нету");
    }

    public void infoLoadPassanger(int passanger, int businessPassanger) {
        System.out.println("Пассажиров зарегистрировано на рейс " + passanger + " и " + businessPassanger +
                " в бизнес класс");
        System.out.println((!isBusinessClass ? "Бизнес класса нет! " : quantityBusinessPass >= businessPassanger ?
                "Пассажиры размещены в бизнес классе! " : "В бизнес классе нет места! ")
                + (quantityPassengers >= passanger ? "Самолёт загружен" : "Вам нужен самолёт побольше"));
    }

    public int getQuantityBusinessPass() {
        return quantityBusinessPass;
    }

    public void setQuantityBusinessPass(int quantityBusinessPass) {
        this.quantityBusinessPass = quantityBusinessPass;
    }

    public double getkWPower() {
        return kWPower;
    }

    public void setkWPower(double kWPower) {
        this.kWPower = kWPower * 0.74;
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
