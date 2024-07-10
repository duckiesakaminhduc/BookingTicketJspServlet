package com.bookingticket.controller.service;

import com.bookingticket.controller.dto.MovieEditDto;

public interface MovieService {
    public MovieEditDto getMovieById(Long id);
}
