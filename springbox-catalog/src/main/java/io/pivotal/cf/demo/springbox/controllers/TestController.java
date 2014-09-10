package io.pivotal.cf.demo.springbox.controllers;

import io.pivotal.cf.demo.springbox.models.Genre;
import io.pivotal.cf.demo.springbox.models.Movie;
import io.pivotal.cf.demo.springbox.repositories.GenreRepository;
import io.pivotal.cf.demo.springbox.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    GenreRepository genreRepository;

    @RequestMapping("/testMovies")
    public List<Movie> movies() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    @RequestMapping("/putSomethingIn")
    public void putSomethingIn() {
        Movie movie = new Movie();
        movie.setMlId("123456");
        movie.setTitle("my title");

        Genre genre = genreRepository.findByName("Action").get(0);

        movie.setGenres(Arrays.asList(genre));

        movieRepository.save(movie);
    }
}
