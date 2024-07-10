package com.bookingticket.controller.service.Impl;

import com.bookingticket.controller.dao.MovieDao;
import com.bookingticket.controller.dto.MovieEditDto;
import com.bookingticket.controller.service.MovieService;

public class MovieServiceImpl implements MovieService {

    MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public MovieEditDto getMovieById(Long id) {
        return movieDao.getMovieById(id);
    }
}
