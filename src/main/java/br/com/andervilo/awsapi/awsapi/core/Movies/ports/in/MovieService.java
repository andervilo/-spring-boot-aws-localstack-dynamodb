package br.com.andervilo.awsapi.awsapi.core.Movies.ports.in;

import java.util.List;

import br.com.andervilo.awsapi.awsapi.core.Movies.domain.Movie;

public interface MovieService {
    
    Movie addMovie(Movie movie);

	void deleteMovieById(String id);

	Movie updateMovie(Movie movie);

	List<Movie> getMovies();

	Movie getMovieById(String id);
}
