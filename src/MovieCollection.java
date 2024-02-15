import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class MovieCollection {
    private ArrayList<Movie> collection;
    public MovieCollection() {
        this.collection = new ArrayList<Movie>();
        readFile();
        start();
    }

    private void readFile() {
        try {
            ArrayList<String[]> data = new ArrayList<String[]>();
            File movies = new File("src//movies_data.csv");
            Scanner s = new Scanner(movies);
            int lineCount = 0;
            while (s.hasNext()) {
                if (lineCount != 0) {
                    String[] line = s.nextLine().split(",");
                    String title = line[0];
                    String[] cast = line[1].split("\\|");
                    String director = line[2];
                    String overview = line[3];
                    int runtime = Integer.parseInt(line[4]);
                    double rating = Double.parseDouble(line[5]);
                    collection.add(new Movie(title, cast, director, overview, runtime, rating));
                } else {
                    lineCount++;
                    s.nextLine();
                }
            }
        } catch (IOException e) { }
    }

    private void start() {
        System.out.println("Welcome to the movie collection!");
        String menuOption = "";

        while (!menuOption.equals("q")) {
            System.out.println("------------ Main Menu ----------");
            System.out.println("- search (t)itles");
            System.out.println("- search (c)ast");
            System.out.println("- (q)uit");
            System.out.print("Enter choice: ");
            menuOption = scanner.nextLine();

            if (menuOption.equals("t")) {
                searchTitles();
            } else if (menuOption.equals("c")) {
                searchCast();
            } else if (menuOption.equals("q")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
