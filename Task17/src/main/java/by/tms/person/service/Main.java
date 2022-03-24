package by.tms.person.service;

import static by.tms.person.model.ListPersonOperation.printLastNamePerson;

import by.tms.person.model.ListPerson;
import by.tms.person.model.Person;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    ListPerson personList = new ListPerson();
    personList.addPersonList(List.of(new Person("Саша", "Дываппап"),
        new Person("Вася", "Вывавапа"),
        new Person("Федя", "Упарао"),
        new Person("Олег", "Давииыу")));
    printLastNamePerson(personList.getPersonList());
  }
}
