package by.tms.task11_1;

public class Music {

  public static void main(String[] args) {
    Instrument[] instrumentArr = new Instrument[3];
    instrumentArr[0] = createInstrument(Instrument.Type.GUITAR);
    instrumentArr[1] = createInstrument(Instrument.Type.TRUMPET);
    instrumentArr[2] = createInstrument(Instrument.Type.DRUM);

    for (Instrument instrument : instrumentArr) {
      instrument.play();
    }
  }

  public static Instrument createInstrument(Instrument.Type type) {
    switch (type) {
      case GUITAR:
        return new Guitar(6);
      case DRUM:
        return new Drum("60 на 30");
      case TRUMPET:
        return new Trumpet(30);
    }
    return null;
  }
}
