package main.java.com.etraveli.assignment.movie;

import main.java.com.etraveli.assignment.constants.MovieType;

public class Movie {

    private String title;
    private MovieType type;

    public Movie(String title, MovieType type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public MovieType getType() {
        return type;
    }
}
