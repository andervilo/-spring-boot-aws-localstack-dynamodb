package br.com.andervilo.awsapi.awsapi.core.Movies;

import java.util.List;

import br.com.andervilo.awsapi.awsapi.core.Movies.domain.Movie;
import br.com.andervilo.awsapi.awsapi.core.Movies.ports.in.MovieService;
import br.com.andervilo.awsapi.awsapi.core.Movies.ports.out.MovieRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }

    @Override
    public void deleteMovieById(String id) {
        movieRepository.deleteMovieById(id);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepository.updateMovie(movie);
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.getMovies();
    }

    @Override
    public Movie getMovieById(String id) {
        return movieRepository.getMovieById(id);
    }
    
}
