package com.hemanth.paging.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moviecharacter")
public class MovieCharacter {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "movie")
    private String movie;

    public MovieCharacter(int id, String name, String movie) {
        super();
        this.id = id;
        this.name = name;
        this.movie = movie;
    }

    public MovieCharacter() {
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

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "MovieCharacter [id=" + id + ", name=" + name + ", movie=" + movie + "]";
    }
}
