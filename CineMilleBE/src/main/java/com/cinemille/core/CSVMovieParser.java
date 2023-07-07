package com.cinemille.core;

import com.cinemille.web.MovieFacadeImpl;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class CSVMovieParser {

    private MovieFacadeImpl movieFacadeImpl;

    public CSVMovieParser(MovieFacadeImpl movieFacadeImpl) {
        this.movieFacadeImpl = movieFacadeImpl;
    }

    public void readAndSave(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();

        InputStreamReader reader = new InputStreamReader(inputStream);
        CSVReader csvReader = new CSVReader(reader);

        HeaderColumnNameMappingStrategy<Movie> beanStrategy = new HeaderColumnNameMappingStrategy<>();
        beanStrategy.setType(Movie.class);

        CsvToBean<Movie> csvToBean = new CsvToBeanBuilder<Movie>(csvReader)
                .withMappingStrategy(beanStrategy)
                .build();

        List<Movie> movies = csvToBean.parse();
        movies.forEach(movie -> {
            if (Math.abs(ChronoUnit.DAYS.between(movie.getReleaseDate(), movie.getEndDate())) > 21) {
                throw new IllegalArgumentException("The start date and end date of a movie cannot be more than 3 weeks apart.");
            }
        });
        movieFacadeImpl.saveAll(movies);
    }
}
