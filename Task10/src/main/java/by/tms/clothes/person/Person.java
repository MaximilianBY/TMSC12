package by.tms.clothes.person;

import by.tms.clothes.jacket.Jacket;
import by.tms.clothes.pants.Pants;
import by.tms.clothes.shoes.Shoes;

public class Person implements Wardrobe {

  private String name;
  private Jacket jacket;
  private Pants pants;
  private Shoes shoes;

  public Person(String name, Jacket jacket, Pants pants, Shoes shoes) {
    this.name = name;
    this.jacket = jacket;
    this.pants = pants;
    this.shoes = shoes;
  }

  public Person() {
  }

  @Override
  public void dressUp() {

    jacket.putOn();
    pants.putOn();
    shoes.putOn();
  }

  @Override
  public void undress() {
    jacket.takeOff();
    pants.takeOff();
    shoes.takeOff();
  }

  public String getName() {
    return name;
  }
}
