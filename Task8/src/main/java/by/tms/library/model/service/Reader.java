package by.tms.library.model.service;

public class Reader {

  private String name;
  private String dateBirth;
  private String phoneNumber;
  private int ticketID;
  private String faculty;

  public Reader(String name, String dateBirth, String phoneNumber, int ticketID, String faculty) {
    this.name = name;
    this.dateBirth = dateBirth;
    this.phoneNumber = phoneNumber;
    this.ticketID = ticketID;
    this.faculty = faculty;
  }

  public String getName() {
    return name;
  }

  public String getDateBirth() {
    return dateBirth;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public int getTicketID() {
    return ticketID;
  }

  public String getFaculty() {
    return faculty;
  }
}
