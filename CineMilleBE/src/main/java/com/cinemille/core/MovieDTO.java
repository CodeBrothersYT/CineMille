package com.cinemille.core;

import java.time.LocalDate;

public record MovieDTO(String title, String description, long duration, LocalDate releaseDate, LocalDate endDate) {}
