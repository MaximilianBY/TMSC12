package by.tms.soap.repository;

import by.tms.soap.model.Sex;
import by.tms.soap.model.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {

  private final List<Student> studentList = new ArrayList<>();

  @PostConstruct
  public void initData() {
    Student student1 = new Student();
    student1.setName("Ivan");
    student1.setSurname("Ivanov");
    student1.setUniversity("BSPU");
    student1.setCourse(1);
    student1.setAge(18);
    student1.setSex(Sex.MALE);

    studentList.add(student1);

    Student student2 = new Student();
    student2.setName("Petr");
    student2.setSurname("Petrov");
    student2.setUniversity("BSTU");
    student2.setCourse(3);
    student2.setAge(22);
    student2.setSex(Sex.MALE);

    studentList.add(student2);

    Student student3 = new Student();
    student3.setName("Lisa");
    student3.setSurname("Sidorova");
    student3.setUniversity("BATU");
    student3.setCourse(5);
    student3.setAge(23);
    student3.setSex(Sex.FEMALE);

    studentList.add(student3);
  }

  public Student findStudent(String name, String surname) {
    Student result = null;

    for (Student student : studentList) {
      if (name.equals(student.getName()) && surname.equals(student.getSurname())) {
        result = student;
      }
    }

    return result;
  }
}
