package by.tms.person.service;

import by.tms.person.model.Employee;
import by.tms.person.model.Lido;

public class Main {

  public static void main(String[] args) {
    Lido lido = new Lido();
    lido.addEmployee(new Employee("М.Э. Полторжицкий", 256.40));
    lido.addEmployee(new Employee("А.В. Иванов", 437.99));
    lido.addEmployee(new Employee("А.Р. Медведева", 189.42));
    lido.addEmployee(new Employee("А.К. Рай", 465.56));
    lido.addEmployee(new Employee("Д.С. Франтов", 489.56));

    lido.generateReport();
  }
}
