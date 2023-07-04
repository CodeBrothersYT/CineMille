package com.cinemille.web;

import com.cinemille.core.Movie;
import com.cinemille.core.MovieDTO;
import com.cinemille.core.MovieMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<MovieDTO> getAllMovies() {
        List<Movie> allMovies = movieFacadeImpl.getAllMovies();
        return allMovies.stream().map(movie -> mapper.toDto(movie)).toList();
    }
}
