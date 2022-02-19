package by.tms.task11_2;

import by.tms.task11_2.Season.Type;

public class Main {

  public static void main(String[] args) {
    getSeason(Type.MARCH).getDescription();
  }

  public static Season getSeason(Type month) {
    switch (month) {
      case JUNE:
      case JULY:
      case AUGUST:
        return new Summer(30);
      case SEPTEMBER:
      case OCTOBER:
      case NOVEMBER:
        return new Autumn(month.name, 10);
      case DECEMBER:
      case JANUARY:
      case FEBRUARY:
        return new Winter(-20);
      case MARCH:
      case APRIL:
      case MAY:
        return new Spring(month.name, 10);
    }
    return null;
  }
}
