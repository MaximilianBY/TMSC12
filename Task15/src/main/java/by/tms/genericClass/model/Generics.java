package by.tms.genericClass.model;

import java.io.Serializable;

public class Generics<T, V, K> {

  private T someString;
  private V someAnimal;
  private K someNum;

  public <T extends Comparable> T getSomeString(Object obj, Class<String> clazz) {
    return (T) obj;
  }

  public <V extends Serializable> V getSomeAnimal(Object obj, Class<Animal> clazz) {
    return (V) obj;
  }

  public <K> K getSomeNum(Object obj, Class<Number> clazz) {
    return (K) obj;
  }

}
