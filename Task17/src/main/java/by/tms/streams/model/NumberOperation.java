package by.tms.streams.model;

import java.util.Collection;

public interface NumberOperation<T extends Collection<? extends Number>> {

  Collection<?> getEvenNumber();

  Collection<?> getEvenNumber(int divider);
}
