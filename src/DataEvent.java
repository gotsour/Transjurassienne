public class DataEvent {
    private String year;
    private String raceCat;

    public DataEvent(String year, String raceCat) {
        this.year = year;
        this.raceCat = raceCat;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRaceCat() {
        return raceCat;
    }
}
