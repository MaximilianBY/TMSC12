package by.tms.car.model;

public class Malfunction extends Exception {

  public String message() {
    return "Что пошло не так, ДВС не запущен!";
  }
}
