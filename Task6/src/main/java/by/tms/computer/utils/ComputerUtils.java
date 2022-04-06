package by.tms.computer.utils;

import by.tms.computer.model.Computer;
import java.util.Random;
import java.util.Scanner;
import lombok.experimental.UtilityClass;

@UtilityClass

public class ComputerUtils {

  private static final String COMPUTER_OFF = "Computer shutdown";
  private static final String COMPUTER_ON = "Computer working";
  private static final String COMPUTER_BURN = "Computer burned out";

  public static void turnOn(Computer computer) {
    if (computer.isBurned()) {
      System.out.println(COMPUTER_BURN);
    } else {
      System.out.println(COMPUTER_ON);
    }
  }

  public static void turnOff(Computer computer) {
    System.out.println("Внимание! Введите 0 или 1: ");
    while (!computer.isBurned()) {
      if (computer.getResource() > 0 && new Scanner(System.in).nextInt() == new Random().nextInt(
          2)) {
        System.out.println(COMPUTER_OFF);
        computer.setResource(computer.getResource() - 1);
        turnOn(computer);
      } else {
        computer.setBurned(true);
        System.out.println(COMPUTER_BURN);
      }
    }
  }
}
