package br.com.andervilo.awsapi.awsapi.core.Movies.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    private String id;

    private String title;

    private String description;
    
}
