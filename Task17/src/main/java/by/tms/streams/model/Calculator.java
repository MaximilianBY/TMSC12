package by.tms.streams.model;

import java.util.Collection;
import java.util.stream.Collectors;

public class Calculator<T extends Collection<? extends Number>> implements NumberOperation<T> {

  private T inpSet;

  public Calculator(T inpSet) {
    this.inpSet = inpSet;
  }

  @Override
  public Collection<?> getEvenNumber() { //вообще, первые 2 задачи, можно решить за один метод, там где передаем в метод просто делитель, а этот можно сказать лишний
    return inpSet.stream()
        .filter(number -> number.intValue() % 2 == 0)
        .collect(Collectors.toSet());
  }

  @Override
  public Collection<?> getEvenNumber(int divider) {
    return inpSet.stream()
        .filter(number -> number.intValue() % divider == 0)
        .collect(Collectors.toSet());
  }
}
