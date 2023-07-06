package com.cinemille.core;

import com.cinemille.web.MovieFacadeImpl;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Component
public class CSVMovieParser {

    private MovieFacadeImpl movieFacadeImpl;

    public CSVMovieParser(MovieFacadeImpl movieFacadeImpl) {
        this.movieFacadeImpl = movieFacadeImpl;
    }

    public void readAndSave() throws FileNotFoundException {

        CSVReader csvReader = new CSVReader(new FileReader("CineMilleBE/src/main/resources/movies.csv"));

        HeaderColumnNameMappingStrategy<Movie> beanStrategy = new HeaderColumnNameMappingStrategy<>();
        beanStrategy.setType(Movie.class);

        CsvToBean<Movie> csvToBean = new CsvToBeanBuilder<Movie>(csvReader)
                .withMappingStrategy(beanStrategy)
                .build();

        List<Movie> movies = csvToBean.parse();
        movieFacadeImpl.saveAll(movies);
    }
}
