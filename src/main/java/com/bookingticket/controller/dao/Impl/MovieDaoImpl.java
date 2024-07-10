package com.bookingticket.controller.dao.Impl;

import com.bookingticket.controller.dao.MovieDao;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.dto.MovieEditDto;
import com.bookingticket.controller.mapper.MovieEditDtoMapper;
import org.jdbi.v3.core.Jdbi;

public class MovieDaoImpl implements MovieDao {
    private Jdbi jdbi;

    public MovieDaoImpl() {
        this.jdbi = Database.getJdbi();
        jdbi.registerRowMapper(new MovieEditDtoMapper());
    }

    @Override
    public MovieEditDto getMovieById(Long id) {
        String q = "SELECT m.movie_name,m.`status`,m.url_img,m.country,m.duration,m.manager,m.performers,m.premiere,m.subtitle,m.recommend,m.premiere FROM movie m where m.id = ?";
        MovieEditDto movie = null;
        movie = jdbi.withHandle(handle -> {
            return handle.createQuery(q)
                    .bind(0,id)
                    .mapTo(MovieEditDto.class)
                    .findOnly();
        });
        return movie;
    }

    public static void main(String[] args) {
        MovieDaoImpl m = new MovieDaoImpl();
        System.out.println(m.getMovieById(1l));
    }
}
