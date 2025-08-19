package com.ernesto.cloud.azure.ecommerce.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class MoviePageResponseDto {
    public int page;
    public ArrayList<MovieResponseDto> results;
    public int total_pages;
    public int total_results;
}
