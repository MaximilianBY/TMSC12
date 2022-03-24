package by.tms.spaceport;

import java.util.Random;

public class Shuttle implements IStart {

  @Override
  public boolean isCheck() {
    Random random = new Random();
    return random.nextInt(11) > 3;
  }

  @Override
  public void startEngine() {
    System.out.println("Двигатели Шатла запущены. Все системы в норме.");
  }

  @Override
  public void start() {
    System.out.println("Отсчёт!");
    for (int i = 10; i >= 0; i--) {
      System.out.println(i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
    }
    System.out.println("Старт Шатла");
  }
}
