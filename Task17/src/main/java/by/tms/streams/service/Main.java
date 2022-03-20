package by.tms.streams.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
//    Set<Integer> integerSet = (Set<Integer>) createCollection(50);
//    Calculator<Set<Integer>> intList = new Calculator<>(integerSet);
//    intList.getEvenNumber().stream().forEach(n -> System.out.println(n));
//    intList.getEvenNumber(2).stream().forEach(n -> System.out.println(n));
    List<String> nameList = fillList();
    nameList.stream()
        .forEach(
            name -> System.out.println(name.substring(0, 1).toUpperCase() + name.substring(1)));
  }

  private static Collection<? extends Number> createCollection(int size) {
    return new Random()
        .ints(size, 0, 101)
        .boxed()
        .collect(Collectors.toSet());
  }

  private static List<String> fillList() {
    List<String> fillName = new ArrayList<>();
    fillName.add("alla");
    fillName.add("dima");
    fillName.add("zhanna");
    return fillName;
  }
}
