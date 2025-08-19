package com.ernesto.cloud.azure.ecommerce.dto;

import lombok.*;
import java.util.ArrayList;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class MovieResponseDto {
    public boolean adult;
    public String backdrop_path;
    public int id;
    public String title;
    public String original_title;
    public String overview;
    public String poster_path;
    public String media_type;
    public String original_language;
    public ArrayList<Integer> genre_ids;
    public double popularity;
    public String release_date;
    public boolean video;
    public double vote_average;
    public int vote_count;
}
