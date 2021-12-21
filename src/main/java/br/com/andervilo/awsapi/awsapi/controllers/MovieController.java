package br.com.andervilo.awsapi.awsapi.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andervilo.awsapi.awsapi.entities.Movie;
import br.com.andervilo.awsapi.awsapi.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@Getter
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/movie")
public class MovieController {

    private MovieRepository movieRepository;

    @GetMapping
    public Iterable<Movie> listMovie() {
        return getMovieRepository().findAll();
    }

    @GetMapping(value = "/{id}")
    public Movie getMovie(@PathVariable String id) {
        return getMovieRepository().findById(id).get();
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return getMovieRepository().save(movie);
    }

    @PutMapping(value = "/{id}")
    public Movie updateMovie(@PathVariable String id, @RequestBody Movie movie) {
        Movie existingMovie = getMovieRepository().findById(id).get();
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setTitle(movie.getTitle());
        return getMovieRepository().save(existingMovie);
    }

    @DeleteMapping(value = "/{id}")
    public Boolean deleteMovie(@PathVariable String id) {
        Movie existingMovie = getMovieRepository().findById(id).get();
        getMovieRepository().delete(existingMovie);
        return Boolean.TRUE;
    }
}
