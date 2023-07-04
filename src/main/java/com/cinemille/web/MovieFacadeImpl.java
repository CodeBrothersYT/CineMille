package com.cinemille.web;

import com.cinemille.core.Movie;
import com.cinemille.core.MovieRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieFacadeImpl implements MovieFacade{

    private MovieRepository movieRepository;

    public MovieFacadeImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(Specification<Movie> specification) {
        return movieRepository.findAll(specification);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
