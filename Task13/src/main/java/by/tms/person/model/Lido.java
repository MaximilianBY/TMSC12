package by.tms.person.model;

import java.util.ArrayList;
import java.util.List;

public class Lido implements Report {

  private List<Employee> listEmployee = new ArrayList<>();

  @Override
  public void generateReport() {
    for (Employee employee : listEmployee) {
      System.out.printf("|%-20s|%10.2f|%n", employee.getFullName(), employee.getSalary());
    }
  }

  public void setListEmployee(Employee employee) {
    this.listEmployee.add(employee);
  }
}
