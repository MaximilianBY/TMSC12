package by.tms.spaceport;

public class Start {

  public static void main(String[] args) {
    SpacePort spacePort = new SpacePort();
    spacePort.launch(new Shuttle());
    spacePort.launch(new SpaceX());
  }
}
