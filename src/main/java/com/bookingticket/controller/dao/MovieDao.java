package com.bookingticket.controller.dao;

import com.bookingticket.controller.dto.MovieEditDto;

public interface MovieDao {
    public MovieEditDto getMovieById(Long id);
    public boolean deleteMovieById(Long id);
}
