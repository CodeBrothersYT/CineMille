package com.cinemille.web;

import com.cinemille.core.Movie;
import com.cinemille.core.MovieDTO;
import com.cinemille.core.MovieDateSpecification;
import com.cinemille.core.MovieMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    private MovieFacadeImpl movieFacadeImpl;
    private MovieMapper mapper;

    public MovieController(MovieFacadeImpl movieFacadeImpl, MovieMapper mapper) {
        this.movieFacadeImpl = movieFacadeImpl;
        this.mapper = mapper;
    }

    @GetMapping("/movies")
    public List<MovieDTO> getAllMovies(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        MovieDateSpecification movieDateSpecification = new MovieDateSpecification(startDate, endDate);
        List<Movie> allMovies = movieFacadeImpl.getAllMovies(movieDateSpecification);
        return allMovies.stream().map(mapper::toDto).toList();
    }
}
