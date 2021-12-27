package br.com.andervilo.awsapi.awsapi.application.repositories.movie;

import br.com.andervilo.awsapi.awsapi.application.entities.MovieEntity;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface MovieSpringRepository extends DynamoDBCrudRepository<MovieEntity, String>{
    
}
