package com.ernesto.cloud.azure.ecommerce.controller;

import com.ernesto.cloud.azure.ecommerce.dto.MoviePageResponseDto;
import com.ernesto.cloud.azure.ecommerce.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins="*")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/fetch")
    @ResponseBody
    public Mono<MoviePageResponseDto> fetch()  {
        return movieService.fetchMovies();
    }
}
