public class DataEvent {
    private String year;
    private String raceCat;

    public DataEvent(String year, String raceCat) {
        this.year = year;
        this.raceCat = raceCat;
    }

    public String getRaceCat() {
        return raceCat;
    }
}
