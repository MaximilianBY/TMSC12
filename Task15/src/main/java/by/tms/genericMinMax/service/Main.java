package by.tms.genericMinMax.service;

import by.tms.genericMinMax.model.MinMax;

public class Main {

  public static void main(String[] args) {
    Number[] arrNum = {9.5, 12.0, 532534.5, 2356546.2};
    MinMax<Number> minMax = new MinMax<>(arrNum);
    minMax.checkMinMaxValue();
    System.out.println(minMax.getMaxValue());
    System.out.println(minMax.getMinValue());
  }
}
