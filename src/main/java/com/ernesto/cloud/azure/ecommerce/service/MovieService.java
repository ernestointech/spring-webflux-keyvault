package com.ernesto.cloud.azure.ecommerce.service;


import com.ernesto.cloud.azure.ecommerce.client.TmdbClient;
import com.ernesto.cloud.azure.ecommerce.dto.MoviePageResponseDto;
import com.ernesto.cloud.azure.ecommerce.dto.MovieResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class MovieService {

    @Autowired
    TmdbClient tmdbClient;


    public Mono<MoviePageResponseDto> fetchMovies() {
        return tmdbClient.getMovieTrending();
    }
}
