public class Main {
    public static void main(String[] args) {
        PassengerTransport fordTransit = new PassengerTransport();
        fordTransit.setBrand("Форд Транзит");
        fordTransit.setBodyType("микроавтобус");
        fordTransit.setHorsePower(120);
        fordTransit.setkWPower(fordTransit.getHorsePower());
        fordTransit.setMaxSpeed(140);
        fordTransit.setWeight(2000);
        fordTransit.setQuantityPassengers(8);
        fordTransit.setConsumption(9);
        fordTransit.setQuantityWheels(4);
        System.out.println(fordTransit.info() + "\n");
        fordTransit.infoTravel(3);
        System.out.println();

        FreightTransport scania = new FreightTransport();
        scania.setBrand("Scania");
        scania.setConsumption(24);
        scania.setHorsePower(1000);
        scania.setkWPower(scania.getHorsePower());
        scania.setMaxSpeed(120);
        scania.setLoadCapacity(30);
        scania.setWeight(5000);
        scania.setQuantityWheels(6);
        System.out.println(scania.info() + "\n");
        scania.infoLoadCapacity(31);
        System.out.println();

        PassengerAir airBus = new PassengerAir();
        airBus.setBrand("AIRBUS");
        airBus.setBusinessClass(false);
        airBus.setHorsePower(5000);
        airBus.setMaxSpeed(900);
        airBus.setkWPower(airBus.getHorsePower());
        airBus.setWeight(20000);
        airBus.setWingspan(10);
        airBus.setMinRunLengthTakeoff(1000);
        airBus.setQuantityPassengers(200);
        System.out.println(airBus.info() + "\n");
        airBus.infoLoadPassanger(190, 5);
        System.out.println();

        MilitaryAir f18 = new MilitaryAir();
        f18.setBrand("F/A 18 HORNET");
        f18.setCatapult(true);
        f18.setHorsePower(10000);
        f18.setMaxSpeed(1200);
        f18.setkWPower(f18.getHorsePower());
        f18.setWeight(2000);
        f18.setWingspan(7);
        f18.setQuantityRockets(10);
        f18.setMinRunLengthTakeoff(600);
        System.out.println(f18.info() + "\n");
        f18.infoRocketLaunch(10);
        f18.ejection();
    }
}
