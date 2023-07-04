package com.cinemille.core;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Entity
@Table
public class Movie {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private LocalDate startingDate;
    @NonNull
    private LocalDate endingDate;

    @NonNull
    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(@NonNull LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    @NonNull
    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(@NonNull LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    @NonNull
    private int length;

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
