package com.bookingticket.controller.dao;

import com.bookingticket.controller.dto.MovieDto;
import com.bookingticket.controller.dto.MovieEditDto;
import io.vavr.Tuple3;
import io.vavr.collection.Seq;

import java.util.List;
import java.util.Optional;

public interface MovieDao {
    public MovieEditDto getMovieById(Long id);

    public boolean deleteMovieById(Long id);

    public boolean addMovie(MovieDto movieDto);

//    @SqlQuery("SELECT id,duration,url_img FROM `movie` where status = 2")
//    @RegisterBeanMapper(MovieDto.class)
    public List<MovieDto> getMoviesByStatus();

    public List<MovieDto> getAllMovies();

    public MovieDto getMovieByMovie_ID(Long id);

}
