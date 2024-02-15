public class Movie {
    private String name;
    private String[] cast;
    private String director;
    private String overview;
    private int runtime;
    private double rating;

    public Movie (String name, String[] cast, String director, String overview, int runtime, double rating) {
        this.name = name;
        this.cast = cast;
        this.director = director;
        this.overview = overview;
        this.runtime = runtime;
        this.rating = rating;
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
}