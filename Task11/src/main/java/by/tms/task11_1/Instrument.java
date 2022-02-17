package by.tms.task11_1;

public interface Instrument {

  void play();

  enum Type {
    GUITAR, DRUM, TRUMPET;
  }

  String KEY = "До мажор";
}
