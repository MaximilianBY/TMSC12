package by.tms.task11_1;

public class Drum implements Instrument {

  private String drumSize;

  public Drum(String drumSize) {
    this.drumSize = drumSize;
  }

  @Override
  public void play() {
    System.out.println("Стучит барабан размерами " + drumSize);
  }
}
