package com.cinemille.web;

import com.cinemille.core.Movie;
import com.cinemille.core.MovieRepository;
import com.cinemille.core.specifications.ExpiredMoviesSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class MovieFacadeImpl implements MovieFacade {

    private final MovieRepository movieRepository;

    public MovieFacadeImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> saveAll(List<Movie> movies) {
        return movieRepository.saveAll(movies);
    }

    @Override
    public List<Movie> getAvailable() {
        return movieRepository.findAll(Specification.not(new ExpiredMoviesSpecification()));
    }

    @Override
    public Page<Movie> getHistoryMovies(Pageable pageable) {
        return movieRepository.findAll(new ExpiredMoviesSpecification(), pageable);
    }
}
