import java.time.LocalDate;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.lang.IO;

void main(String[] args) {
    ArrayList<WatchEntry> entries = load();

    IO.println("Enter your watch times in hours (type 'done' when finished)\n");

    while (true) {
        String line = IO.readln("");
        if (line.equalsIgnoreCase("done") || line == null) {
            break;
        }
        try {
            double time = Double.parseDouble(line);
            entries.add(new WatchEntry(LocalDate.now(), time));
        } catch (NumberFormatException e) {
            IO.println("Please enter a valid number.\n");
        }
    }
    save(entries);
}

// Saves the new entries that the user inputs
void save(ArrayList<WatchEntry> entries) {
    try (PrintWriter out = new PrintWriter(new FileWriter("watchtimes.txt"))) {
        for (int j = 0; j < entries.size(); j++) {
            out.println(entries.get(j).getDate() + "," + entries.get(j).getHours());
        }
    } catch (IOException e) {
        IO.println("Could not save.");
    }
}

// Loads the previous entries entered
ArrayList<WatchEntry> load() {
    ArrayList<WatchEntry> entries = new ArrayList<>();
    try (BufferedReader in = new BufferedReader(new FileReader("watchtimes.txt"))) {
        String line = "";
        while ((line = in.readLine()) != null) {
            String[] entry = line.split(","); // Formatted like 'date, time'
            entries.add(new WatchEntry(LocalDate.parse(entry[0]), Double.parseDouble(entry[1])));
        }
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    } catch (IOException e) {
        IO.println("Could not load file.");
    }
    return entries;
}