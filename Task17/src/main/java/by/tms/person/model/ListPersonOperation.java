package by.tms.person.model;

import java.util.List;

public class ListPersonOperation {

  //к сожалению, так я и не разобрался как вернуть объект Operation<String>, буду признателен, если разъясните этот момент еще раз
  public static void printLastNamePerson(List<Person> list) {
    list.stream().filter(person -> person.getLastName().startsWith("Д"))
        .forEach(person -> System.out.println(person.getLastName()));
  }
}
