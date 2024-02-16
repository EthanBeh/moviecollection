import java.util.ArrayList;

public class Movie {
    private String name;
    private String[] cast;
    private String director;
    private String overview;
    private int runtime;
    private double rating;
    public static ArrayList<String> actors = new ArrayList<String>();

    public Movie (String name, String[] cast, String director, String overview, int runtime, double rating) {
        this.name = name;
        this.cast = cast;
        this.director = director;
        this.overview = overview;
        this.runtime = runtime;
        this.rating = rating;
        addCast();
    }


    public String getName() {
        return name;
    }

    public String[] getCast() {
        return cast;
    }

    public String getDirector() {
        return director;
    }

    public String getOverview() {
        return overview;
    }

    public int getRuntime() {
        return runtime;
    }

    public double getRating() {
        return rating;
    }

    private void addCast() {
        boolean addMember = true;
        for (int i = 0; i < cast.length; i++) {
            for (int j = 0; j < actors.size(); j++) {
                if (actors.get(j).equals(cast[i])) {
                    addMember = false;
                    break;
                }
            }
            if (addMember) {
                actors.add(cast[i]);
                addMember = true;
            }
        }
    }
    public String toString() {
        String str = "Title: " + getName() + "\nRuntime: " + getRuntime() + " min\nDirected by: " + getDirector() + "\nCast: ";
        for (int i = 0; i < cast.length - 1; i++) {
            str += cast[i] + ", ";
        } str += cast[cast.length - 1];
        str += "\nOverview: " + getOverview() + "\nUser rating: " + getRating();
        return str;
    }
}