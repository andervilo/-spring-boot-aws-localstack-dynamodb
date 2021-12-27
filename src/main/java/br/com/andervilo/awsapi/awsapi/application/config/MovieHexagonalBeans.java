package br.com.andervilo.awsapi.awsapi.application.config;

import br.com.andervilo.awsapi.awsapi.application.repositories.movie.MovieRepositoryImpl;
import br.com.andervilo.awsapi.awsapi.application.repositories.movie.MovieSpringRepository;
import br.com.andervilo.awsapi.awsapi.core.Movies.MovieServiceImpl;
import br.com.andervilo.awsapi.awsapi.core.Movies.ports.in.MovieService;
import br.com.andervilo.awsapi.awsapi.core.Movies.ports.out.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MovieHexagonalBeans {

    private final MovieSpringRepository movieRepository;

    @Bean
    public MovieRepository movieRepository(){
        return new MovieRepositoryImpl(movieRepository);
    }

    @Bean
    public MovieService movieService(){
        return new MovieServiceImpl(movieRepository());
    }

}
