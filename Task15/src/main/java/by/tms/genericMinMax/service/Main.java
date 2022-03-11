package by.tms.genericMinMax.service;

import by.tms.genericMinMax.model.MinMax;

public class Main {

  public static void main(String[] args) {
    Integer[] arrNum = {4, 6, 734, 7, 86, 45, 34547};
    MinMax<Integer> minMax = new MinMax<>(arrNum);
    minMax.printMinMaxValue();
  }
}
