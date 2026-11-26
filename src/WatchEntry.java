import java.time.LocalDate;

public class WatchEntry {
    private final LocalDate date;
    private final double hours;

    public WatchEntry(LocalDate date, double hours) {
        this.date = date;
        this.hours = hours;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getHours() {
        return hours;
    }
}
