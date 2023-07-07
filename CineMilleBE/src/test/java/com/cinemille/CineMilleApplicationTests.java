package com.cinemille;

import com.cinemille.core.Movie;
import com.cinemille.core.MovieRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    @Transactional
    void canGetAll() throws Exception {
        mockMvc.perform(get("/api/v1/movies"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$[0].title").value("Iron Main"))
                .andExpect(jsonPath("$[0].description").value("L'uomo Airone"))
                .andExpect(jsonPath("$[0].duration").value(120));
    }

    @Test
    @Transactional
    void canGetHistory() throws Exception {

        mockMvc.perform(get("/api/v1/movies/history"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$[0].title").value("Transformers"))
                .andExpect(jsonPath("$[0].description").value("Macchine che parlano"))
                .andExpect(jsonPath("$[0].duration").value(180));
    }


    public static Movie createMovie() {
        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Iron Man");
        movie.setDescription("Un bel film su Iron Man");
        movie.setDuration(120);
        movie.setReleaseDate(LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ISO_DATE)));
        movie.setEndDate(LocalDate.parse(LocalDate.now().plusDays(14).format(DateTimeFormatter.ISO_DATE)));
        return movie;
    }
}