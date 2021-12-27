package br.com.andervilo.awsapi.awsapi.application.repositories.movie;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import br.com.andervilo.awsapi.awsapi.application.entities.MovieEntity;
import br.com.andervilo.awsapi.awsapi.core.Movies.domain.Movie;
import br.com.andervilo.awsapi.awsapi.core.Movies.ports.out.MovieRepository;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
@Component
@AllArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {

    //@Autowired
    private MovieSpringRepository movieSpringRepository;

    @Override
    public Movie addMovie(Movie movie) {
        var movieToSave = domainToEntity(movie);
        return entityToDomain(movieSpringRepository.save(movieToSave));
    }

    @Override
    public void deleteMovieById(String id) {
        var existingMovie = movieSpringRepository.findById(id)
                            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));

        movieSpringRepository.deleteById(id);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        var existingMovie = movieSpringRepository.findById(movie.getId())
                            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));

        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDescription(movie.getDescription());
        return entityToDomain(movieSpringRepository.save(existingMovie));
    }

    @Override
    public List<Movie> getMovies() {
        List<Movie> movies = StreamSupport
                                .stream(movieSpringRepository.findAll().spliterator(), false)
                                .map(this::entityToDomain)
                                .collect(Collectors.toList());
        return movies;
    }

    @Override
    public Movie getMovieById(String id) {
        var existingMovie = movieSpringRepository.findById(id)
                            .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));

        return entityToDomain(existingMovie);
    }

    private MovieEntity domainToEntity(Movie movie) {
        return MovieEntity
                .builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .build();
    }

    private Movie entityToDomain(MovieEntity movieEntity) {
        return Movie
                .builder()
                .id(movieEntity.getId())
                .title(movieEntity.getTitle())
                .description(movieEntity.getDescription())
                .build();
    }

}
