package com.bookingticket.controller.service.Impl;

import com.bookingticket.controller.dao.MovieDao;
import com.bookingticket.controller.dto.MovieDto;
import com.bookingticket.controller.dto.MovieEditDto;
import com.bookingticket.controller.service.MovieService;

import java.util.List;

public class MovieServiceImpl implements MovieService {



    MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public MovieEditDto getMovieById(Long id) {
        return movieDao.getMovieById(id);
    }

    @Override
    public boolean deleteMovieById(Long id) {
        return movieDao.deleteMovieById(id);
    }

    @Override
    public boolean addMovie(MovieDto movieDto) {
        return movieDao.addMovie(movieDto);
    }

    @Override
    public List<MovieDto> getMoviesByStatus() {
        return movieDao.getMoviesByStatus();
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieDao.getAllMovies();
    }
    public MovieDto getMovieByMovie_ID(Long id){
        return movieDao.getMovieByMovie_ID(id);
    }
}
