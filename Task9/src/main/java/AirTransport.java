public class AirTransport extends Transport {
    private int wingspan; //измеряем в метрах
    private int minRunLengthTakeoff;

    public String infoAirTransport() {
        return "Информация о воздушном судне: " + getBrand() + "\n" +
                "масса воздушного судна: " + getWeight() + " кг" + "\n" +
                "мощность воздушного судна: " + getHorsePower() + " лошадиных сил" + " или " + getkWPower() + " килоВатт" + "\n" +
                "максимальная скорость: " + getMaxSpeed() + " км/ч" + "\n" +
                "размах крыльев: " + getWingspan() + " метров" + "\n" +
                "Минимальная длина взлётно-посадочной полосы для взлёта: " + getMinRunLengthTakeoff() + " метров" + "\n";
    }

    public void infoLoadPassenger(int passenger, int businessPassenger, int quantityBusinessPass, int quantityPassengers,
                                  boolean isBusinessClass) {
        System.out.println("Пассажиров зарегистрировано на рейс " + passenger + " и " + businessPassenger +
                " в бизнес класс");
        System.out.println((!isBusinessClass ? "Бизнес класса нет! " : quantityBusinessPass >= businessPassenger ?
                "Пассажиры размещены в бизнес классе! " : "В бизнес классе нет места! ")
                + (quantityPassengers >= passenger ? "Самолёт загружен" : "Вам нужен самолёт побольше"));
    }

    public void infoRocketLaunch(int missile, int quantityRockets) {
        System.out.println(quantityRockets >= missile ? "Ракета пошла!" : "Боеприпасы отсутствуют!");
    }

    public void ejection(boolean isCatapult) {
        System.out.println(isCatapult ? "Катапультирование прошло успешно" : "У вас нет такой системы");
    }

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    public int getMinRunLengthTakeoff() {
        return minRunLengthTakeoff;
    }

    public void setMinRunLengthTakeoff(int minRunLengthTakeoff) {
        this.minRunLengthTakeoff = minRunLengthTakeoff;
    }
}
