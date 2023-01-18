package com.MoviesLibrary.movies.model;
import javax.persistence.*;


@Entity
@Table(name = "movies")
public class Movies {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "movie_name")
    private String name;
    @Column(name = "release_year")
    private int year;
    @Column(name = "genres")
    private String genres;
    @Column(name = "directed_by")
    private String directed_by;
    @Column(name = "top_cast")
    private String top_cast;

    public Movies(int id, String name, int year, String genres, String directed_by, String top_cast) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genres = genres;
        this.directed_by = directed_by;
        this.top_cast = top_cast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getDirected_by() {
        return directed_by;
    }

    public void setDirected_by(String directed_by) {
        this.directed_by = directed_by;
    }

    public String getTop_cast() {
        return top_cast;
    }

    public void setTop_cast(String top_cast) {
        this.top_cast = top_cast;
    }
}
