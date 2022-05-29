package by.tms;

public class Application {

  public static void main(String[] args) {
    PassengerCar vwPassat = new PassengerCar("Volkswagen", "Passat B5", "Diesel", "stroke", 1900,
        "sedan", 4, "grey");
    PassengerCar vwPassatClone;
    Truck ivecoStralis = new Truck("Iveco", "Stralis", "Diesel", "Stroke", 12000, "Cargo", 4000);
    Truck ivecoStralisClone;
    vwPassatClone = (PassengerCar) vwPassat.clone();
    ivecoStralisClone = (Truck) ivecoStralis.clone();
    System.out.println(vwPassat.hashCode());
    System.out.println(vwPassatClone.hashCode());
    System.out.println(vwPassatClone);

    System.out.println(ivecoStralis.hashCode());
    System.out.println(ivecoStralisClone.hashCode());
    System.out.println(ivecoStralisClone);
  }
}
