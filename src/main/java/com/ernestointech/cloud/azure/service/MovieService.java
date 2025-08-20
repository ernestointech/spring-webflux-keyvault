package com.ernestointech.cloud.azure.service;


import com.ernestointech.cloud.azure.client.TmdbClient;
import com.ernestointech.cloud.azure.dto.MoviePageResponseDto;
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
