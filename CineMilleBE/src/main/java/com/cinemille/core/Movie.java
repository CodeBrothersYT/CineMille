package com.cinemille.core;

import com.opencsv.bean.CsvDate;
import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Entity
@Table
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    private String title;
    
    private String description;
    
    private int duration;
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate endDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle( String title) {
        this.title = title;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription( String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate( LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate( LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                ", endDate=" + endDate +
                '}';
    }
}
