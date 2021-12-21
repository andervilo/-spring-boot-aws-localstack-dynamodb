package br.com.andervilo.awsapi.awsapi.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.andervilo.awsapi.awsapi.entities.Movie;

@EnableScan
@Repository
public interface MovieRepository extends CrudRepository<Movie, String>{
    
}
