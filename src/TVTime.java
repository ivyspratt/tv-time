import java.time.LocalDate;
import java.util.ArrayList;
import java.lang.IO;

void main(String[] args) {
    ArrayList<Double> times = new ArrayList<>();

    IO.println("Enter your watch times in hours (type 'done' when finished)\n");

    while (true) {
        String line = IO.readln("");
        if (line.equalsIgnoreCase("done")) {
            break;
        }
        try {
            double time = Double.parseDouble(line);
            times.add(time);
        } catch (NumberFormatException e) {
            IO.println("Please enter a valid number.\n");
        }
    }

    IO.println(times.size() + " entries entered\n");
}