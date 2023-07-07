package com.cinemille.web;

import com.cinemille.core.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MovieFacade {
    List<Movie> saveAll(List<Movie> movies);

    Page<Movie> getAvailable(Pageable pageable);

    Page<Movie> getHistoryMovies(Pageable pageable);
}
