package by.tms.genericClass.model;

import java.io.Serializable;

public class Generics<T extends Comparable<String>, V extends Serializable, K extends Number> {

  private T someString;
  private V someAnimal;
  private K someNum;

  public <T> T getSomeString(Object obj, Class<String> clazz) {
    return (T) obj;
  }

  public <V> V getSomeAnimal(Object obj, Class<Animal> clazz) {
    return (V) obj;
  }

  public <K> K getSomeNum(Object obj, Class<Number> clazz) {
    return (K) obj;
  }

}
