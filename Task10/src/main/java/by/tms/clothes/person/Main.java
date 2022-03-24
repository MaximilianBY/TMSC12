package by.tms.clothes.person;

import by.tms.clothes.jacket.DenimJacket;
import by.tms.clothes.jacket.GucciJacket;
import by.tms.clothes.pants.GucciPants;
import by.tms.clothes.shoes.GucciShoes;
import by.tms.clothes.shoes.NikeShoes;

public class Main {

  public static void main(String[] args) {
    Person person = new Person("Jack", new DenimJacket(), new GucciPants(), new NikeShoes());
    Person person1 = new Person("Daniel", new GucciJacket(), new GucciPants(), new GucciShoes());
    System.out.println(person.getName() + " одевается!");
    person.dressUp();
    System.out.println("\n" + person1.getName() + " одевается!");
    person1.dressUp();
    System.out.println("\n" + person.getName() + " раздевается!");
    person.undress();
    System.out.println("\n" + person1.getName() + " раздевается!");
    person1.undress();
  }
}
