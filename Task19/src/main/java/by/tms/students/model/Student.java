package by.tms.students.model;

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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCityFrom() {
    return cityFrom;
  }

  public void setCityFrom(String cityFrom) {
    this.cityFrom = cityFrom;
  }

  public String getCityStudy() {
    return cityStudy;
  }

  public void setCityStudy(String cityStudy) {
    this.cityStudy = cityStudy;
  }

  public int getCourse() {
    return course;
  }

  public void setCourse(int course) {
    this.course = course;
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
