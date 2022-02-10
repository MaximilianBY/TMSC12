public class AirTransport extends Transport {
    private int wingspan; //измеряем в метрах
    private int minRunLengthTakeoff;

    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    public int getMinRunLengthTakeoff() {
        return minRunLengthTakeoff;
    }

    public void setMinRunLengthTakeoff(int minRunLengthTakeoff) {
        this.minRunLengthTakeoff = minRunLengthTakeoff;
    }
}
