package by.tms.DBUtils;

import by.tms.student.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {

  private static String GET_ALL_STUDENTS_QUERY = "SELECT * FROM students.students_db JOIN students.students_city_db scd on students_db.id = scd.students_id";
  private static String INSERT_STUDENT_QUERY = "INSERT INTO students.students_db(first_name, last_name, course) VALUES(?, ?, ?)";
  private static String INSERT_STUDENT_CITY_QUERY = "INSERT INTO students.students_city_db(students_id, city_from, city_study) VALUES(LAST_INSERT_ID(), ?, ?)";
  private static String UPDATE_STUDENT_QUERY = "UPDATE students.students_db join students.students_city_db scd on students.students_db.id = scd.students_id SET course = ?, city_study = ? WHERE students_db.id = ?";
  private static String DELETE_STUDENT_QUERY = "DELETE FROM students.students_db WHERE id = ?";

  public static ArrayList<Student> getAllStudents() {
    ArrayList<Student> students = new ArrayList<>();

    try (Connection connection = DBUtils.getConnection()) {
      PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS_QUERY);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String cityFrom = rs.getString("city_from");
        String cityStudy = rs.getString("city_study");
        int course = rs.getInt("course");
        students.add(new Student(id, firstName, lastName, cityFrom, cityStudy, course));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return students;
  }

  public static List<Student> saveStudent(Student student) {
    List<Student> updatedStudents = new ArrayList<>();

    try (Connection connection = DBUtils.getConnection()) {
      PreparedStatement studentStatement = connection.prepareStatement(INSERT_STUDENT_QUERY);
      PreparedStatement studentCityStatement = connection.prepareStatement(
          INSERT_STUDENT_CITY_QUERY);

      studentStatement.setString(1, student.getFirstName());
      studentStatement.setString(2, student.getLastName());
      studentStatement.setInt(3, student.getCourse());

      studentCityStatement.setString(1, student.getCityFrom());
      studentCityStatement.setString(2, student.getCityStudy());

      studentStatement.executeUpdate();
      studentCityStatement.executeUpdate();

      updatedStudents = getAllStudents();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return updatedStudents;
  }

  public static List<Student> updateStudent(int studentId, int course, String cityStudy) {
    List<Student> updatedStudents = new ArrayList<>();

    try (Connection connection = DBUtils.getConnection()) {
      PreparedStatement studentStatement = connection.prepareStatement(UPDATE_STUDENT_QUERY);

      studentStatement.setInt(1, course);
      studentStatement.setString(2, cityStudy);
      studentStatement.setInt(3, studentId);

      studentStatement.executeUpdate();

      updatedStudents = getAllStudents();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return updatedStudents;
  }

  public static List<Student> deleteStudent(int studentId) {
    List<Student> updatedStudents = new ArrayList<>();

    try (Connection connection = DBUtils.getConnection()) {
      PreparedStatement studentStatement = connection.prepareStatement(DELETE_STUDENT_QUERY);

      studentStatement.setInt(1, studentId);

      studentStatement.execute();

      updatedStudents = getAllStudents();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return updatedStudents;
  }

}
