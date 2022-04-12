package by.tms.students.utils;

import by.tms.online_shop.utils.DbUtils;
import by.tms.students.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {

  private static String GET_ALL_STUDENTS_QUERY = "SELECT * FROM students.students_db JOIN students.students_city_db ON students_db.id=students_city_db.id";
  private static String INSERT_STUDENT_QUERY = "INSERT INTO students.students_db(first_name, last_name, course) VALUES(?, ?, ?);";
  private static String INSERT_STUDENT_CITY_QUERY = "INSERT INTO students.students_city_db(city_from, city_study) VALUES(?, ?);";
  private static String UPDATE_STUDENT_QUERY = "UPDATE students.students_db SET course = ? WHERE id = ?;";
  private static String UPDATE_STUDENT_CITY_QUERY = "UPDATE students.students_city_db SET city_study = ? WHERE id = ?;";
  private static String DELETE_STUDENT_QUERY = "DELETE FROM students.students_db WHERE id = ?";
  private static String DELETE_STUDENT_CITY_QUERY = "DELETE FROM students.students_city_db WHERE id = ?";

  public static List<Student> getAllStudents() {
    List<Student> students = new ArrayList<>();

    try (Connection connection = DbUtils.getConnection()) {
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

    try (Connection connection = DbUtils.getConnection()) {
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

    try (Connection connection = DbUtils.getConnection()) {
      PreparedStatement studentStatement = connection.prepareStatement(UPDATE_STUDENT_QUERY);
      PreparedStatement studentCityStatement = connection.prepareStatement(
          UPDATE_STUDENT_CITY_QUERY);

      studentStatement.setInt(1, course);
      studentStatement.setInt(2, studentId);

      studentCityStatement.setString(1, cityStudy);
      studentCityStatement.setInt(2, studentId);

      studentStatement.executeUpdate();
      studentCityStatement.executeUpdate();

      updatedStudents = getAllStudents();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return updatedStudents;
  }

  public static List<Student> deleteStudent(int studentId) {
    List<Student> updatedStudents = new ArrayList<>();

    try (Connection connection = DbUtils.getConnection()) {
      PreparedStatement studentStatement = connection.prepareStatement(DELETE_STUDENT_QUERY);
      PreparedStatement studentCityStatement = connection.prepareStatement(
          DELETE_STUDENT_CITY_QUERY);

      studentStatement.setInt(1, studentId);

      studentCityStatement.setInt(1, studentId);

      studentStatement.execute();
      studentCityStatement.execute();

      updatedStudents = getAllStudents();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return updatedStudents;
  }

}
