package com.cinemille.web;

import com.cinemille.core.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    private MovieFacadeImpl movieFacadeImpl;
    private MovieMapper mapper;
    private CSVMoviesReader csvMoviesReader;

    public MovieController(MovieFacadeImpl movieFacadeImpl, MovieMapper mapper, CSVMoviesReader csvMoviesReader) {

        this.movieFacadeImpl = movieFacadeImpl;
        this.mapper = mapper;
        this.csvMoviesReader = csvMoviesReader;
    }

    @GetMapping("/movies")
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    public List<MovieDTO> getAllMovies(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        MovieDateSpecification movieDateSpecification = new MovieDateSpecification(startDate, endDate);
        List<Movie> allMovies = movieFacadeImpl.getAllMovies(movieDateSpecification);
        return allMovies.stream().map(mapper::toDto).toList();
    }

    @GetMapping("/import-movies")
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    public ResponseEntity<Void> importCSV() {
        csvMoviesReader.readAndSaveMovies();
        return ResponseEntity.ok().build();
    }
}
