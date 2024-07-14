package com.bookingticket.controller.service;

import com.bookingticket.controller.dto.MovieDto;
import com.bookingticket.controller.dto.MovieEditDto;

import java.util.List;

public interface MovieService {
    public MovieEditDto getMovieById(Long id);

    public boolean deleteMovieById(Long id);

    public boolean addMovie(MovieDto movieDto);

    public List<MovieDto> getMoviesByStatus();

    public List<MovieDto> getAllMovies();

    public MovieDto getMovieByMovie_ID(Long id);

}
