package by.tms.student;

public class Student {

  private int id;
  private String firstName;
  private String lastName;
  private String cityFrom;
  private String cityStudy;
  private int course;

  public Student(int id, String firstName, String lastName, String cityFrom,
      String cityStudy, int course) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.cityFrom = cityFrom;
    this.cityStudy = cityStudy;
    this.course = course;
  }

  public Student(String firstName, String lastName, String cityFrom, String cityStudy, int course) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.cityFrom = cityFrom;
    this.cityStudy = cityStudy;
    this.course = course;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getCityFrom() {
    return cityFrom;
  }

  public String getCityStudy() {
    return cityStudy;
  }

  public int getCourse() {
    return course;
  }

  @Override
  public String toString() {
    return "Student info: " + "\n" +
        "ID: " + id + "\n" +
        "firstName: " + firstName + "\n" +
        "lastName: " + lastName + "\n" +
        "from: " + cityFrom + "\n" +
        "studying in : " + cityStudy + "\n" +
        "course: " + course + "\n";
  }
}
