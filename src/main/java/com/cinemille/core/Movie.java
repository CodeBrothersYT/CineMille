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
    private LocalDate startDate;
    @NonNull
    private LocalDate endDate;

    @NonNull
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(@NonNull LocalDate startingDate) {
        this.startDate = startingDate;
    }

    @NonNull
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(@NonNull LocalDate endingDate) {
        this.endDate = endingDate;
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
