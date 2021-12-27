package br.com.andervilo.awsapi.awsapi.application.controllers;

import java.util.List;

import br.com.andervilo.awsapi.awsapi.core.Movies.ports.in.MovieService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.andervilo.awsapi.awsapi.core.Movies.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/movie")
public class MovieController {

    private MovieService movieService;

    @GetMapping
    public List<Movie> listMovie() {
        return getMovieService().getMovies();
    }

    // @Operation(summary = "Get a book by its id")
    // @ApiResponses(value = {
    //         @ApiResponse(responseCode = "200", description = "Found the book",
    //                 content = { @Content(mediaType = "application/json",
    //                         schema = @Schema(implementation = MovieEntity.class)) }),
    //         @ApiResponse(responseCode = "400", description = "Invalid id supplied",
    //                 content = @Content),
    //         @ApiResponse(responseCode = "404", description = "Book not found",
    //                 content = @Content) })
    @GetMapping(value = "/{id}")
    public Movie getMovie(@PathVariable String id) {
        return getMovieService().getMovieById(id);
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return getMovieService().addMovie(movie);
    }

    @PutMapping(value = "/{id}")
    public Movie updateMovie(@PathVariable String id, @RequestBody Movie movie) {
        return getMovieService().updateMovie(movie);
    }

    @DeleteMapping(value = "/{id}")
    public Boolean deleteMovie(@PathVariable String id) {
        getMovieService().deleteMovieById(id);
        return Boolean.TRUE;
    }
}
