package by.tms.task11_1;

public class Guitar implements Instrument {

  private int stringsNum;

  public Guitar(int stringsNum) {
    this.stringsNum = stringsNum;
  }

  @Override
  public void play() {
    System.out.println("Играет гитара с " + stringsNum + " струнами");
  }
}
