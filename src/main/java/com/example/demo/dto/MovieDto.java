package com.example.demo.dto;

import com.example.demo.model.Genre;
import lombok.Builder;

@Builder
public record MovieDto(
    Integer id,
    String name,
    Genre genre,
    Integer year)
{}
