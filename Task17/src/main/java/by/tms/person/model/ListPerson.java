package by.tms.person.model;

import java.util.List;

public class ListPerson {

  private List<Person> personList;

  public List<Person> getPersonList() {
    return personList;
  }

  public void addPersonList(List<Person> person) {
    this.personList = person;
  }
}
