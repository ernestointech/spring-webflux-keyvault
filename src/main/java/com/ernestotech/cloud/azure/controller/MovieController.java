package com.ernestotech.cloud.azure.controller;

import com.ernestotech.cloud.azure.dto.MoviePageResponseDto;
import com.ernestotech.cloud.azure.service.MovieService;
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
