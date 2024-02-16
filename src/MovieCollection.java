import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class MovieCollection {
    private ArrayList<Movie> collection;
    private final Scanner scan = new Scanner(System.in);
    public MovieCollection() {
        this.collection = new ArrayList<Movie>();
        readFile();
        sortCollection();
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
            menuOption = scan.nextLine();

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

    private void sortCollection() {
        for (int i = 0; i < collection.size(); i++) {
            int shift = 0; //i - shift will ALWAYS be the element we're shifting
            while (i - shift > 0 && collection.get(i - shift).getName().compareTo(collection.get(i - shift - 1).getName()) < 0) {
                Movie hold = collection.get(i - shift - 1);
                collection.set(i - shift - 1, collection.get(i - shift));
                collection.set(i - shift,  hold);
                shift++;
            }
        }
    }


    private void searchCast() {
        System.out.print("Enter a person to search for (first or last name): ");
        String search = scan.nextLine();
        ArrayList<String> people = new ArrayList<String>();
        for (int i = 0; i < Movie.actors.size(); i++) {
            if (Movie.actors.get(i).contains(search)) {
                people.add(Movie.actors.get(i));
            }
        }
    }

    private void searchTitles() {
        System.out.print("Enter a title search term: ");
        String search = scan.nextLine();
        ArrayList<Movie> movies = new ArrayList<Movie>();
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getName().toLowerCase().contains(search.toLowerCase())) {
                movies.add(collection.get(i));
                System.out.println(movies.size() + ". " + collection.get(i).getName());
            }
        }
        if (movies.size() == 0) {
            System.out.println("No movie titles match that search term");
        } else {
            System.out.print("Which movie would you like to learn more about?\nEnter number: ");
            int choice = Integer.parseInt(scan.nextLine());
            if (choice > 0 && choice <= movies.size()) {
                System.out.println(movies.get(choice - 1));
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}