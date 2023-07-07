package com.cinemille.web;

import com.cinemille.core.*;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@Validated
public class MovieController {

    private MovieFacade movieFacade;
    private MovieMapper mapper;
    private CSVMovieParser csvMovieParser;

    public MovieController(MovieFacadeImpl movieFacade, MovieMapper mapper, CSVMovieParser csvMovieParser) {

        this.movieFacade = movieFacade;
        this.mapper = mapper;
        this.csvMovieParser = csvMovieParser;
    }

    @GetMapping("/history")
    public List<MovieDTO> getHistory(Pageable pageable) {
            return movieFacade.getHistoryMovies(pageable)
                    .stream()
                    .map(mapper::toDto).toList();
    }

    @GetMapping
    public List<MovieDTO> listAll(Pageable pageable) {
        return movieFacade.getAvailable(pageable)
                .stream()
                .map(mapper::toDto).toList();
    }

    @PostMapping("/import")
    public ResponseEntity<Void> importCSV(@RequestParam("file") MultipartFile file) throws IOException {
        csvMovieParser.readAndSave(file);
        return ResponseEntity.ok().build();
    }
}
