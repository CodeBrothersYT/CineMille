package com.cinemille.core;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

@Component
public class CSVMoviesReader {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public CSVMoviesReader(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public void readAndSaveMovies() {
        String csvFile = "CineMilleBE/src/main/resources/movies.csv";

        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            String headerLine = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                MovieDTO movieDTO = new MovieDTO(data[0], data[1], Long.parseLong(data[2]), LocalDate.parse(data[3]), LocalDate.parse(data[4]));
                Movie entity = movieMapper.toEntity(movieDTO);
                movieRepository.save(entity);
            }

            br.close();
            System.out.println("Data imported successfully.");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
