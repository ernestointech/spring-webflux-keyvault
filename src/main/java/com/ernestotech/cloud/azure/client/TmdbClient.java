package com.ernestotech.cloud.azure.client;
import com.ernestotech.cloud.azure.dto.MoviePageResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component("tmdbClient")
@AllArgsConstructor
public class TmdbClient {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${application.client.tmdb.token}")
    private String token;

    private final String tbdbTokenSecret;


    public Mono<MoviePageResponseDto> getMovieTrending(){
        return webClientBuilder.baseUrl(
                "https://api.themoviedb.org").build().get().uri(uriBuilder->
                        uriBuilder.path("/3/trending/movie/day")
                                .queryParam("language","en-US").build())
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers -> {
                    headers.add("Authorization","Bearer " + tbdbTokenSecret);
                })
                .retrieve()
                .bodyToMono(MoviePageResponseDto.class);
    }
}
