package by.tms.students.service;

import by.tms.students.model.Student;
import by.tms.students.utils.CRUDUtils;

public class Main {

  public static void main(String[] args) {
    System.out.println("View info about students:");
    CRUDUtils.getAllStudents().forEach(System.out::println);

    System.out.println("Add new student:");
    CRUDUtils.saveStudent(new Student("Pavel", "Ershov", "Mogilev", "Minsk", 1))
        .forEach(System.out::println);

    System.out.println("Update student course and city study:");
    CRUDUtils.updateStudent(4, 2, "Mogilev").forEach(System.out::println);

    System.out.println("Delete student info:");
    CRUDUtils.deleteStudent(7);
    CRUDUtils.deleteStudent(8);
    CRUDUtils.deleteStudent(9).forEach(System.out::println);
  }

}
