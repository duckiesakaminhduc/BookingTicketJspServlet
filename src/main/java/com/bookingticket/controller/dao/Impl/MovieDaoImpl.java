package com.bookingticket.controller.dao.Impl;

import com.bookingticket.controller.dao.MovieDao;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.dto.MovieEditDto;
import com.bookingticket.controller.mapper.MovieEditDtoMapper;
import org.jdbi.v3.core.Jdbi;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
                    .bind(0, id)
                    .mapTo(MovieEditDto.class)
                    .findOnly();
        });
        return movie;
    }

    @Override
    public boolean deleteMovieById(Long id) {
        // Query to find all screening ids related to the movie
        String qFindScreeningIds = "SELECT id FROM screening WHERE movie_id = ?";

        // Query to delete tickets related to a screening
        String qDeleteTickets = "DELETE FROM ticket WHERE screening_id = ?";

        // Query to delete screenings related to the movie
        String qDeleteScreenings = "DELETE FROM screening WHERE movie_id = ?";

        // Query to delete theater_movie entries related to the movie
        String qDeleteTheaterMovie = "DELETE FROM theater_movie WHERE movie_id = ?";

        // Query to delete the movie itself
        String qDeleteMovie = "DELETE FROM movie WHERE id = ?";

        return jdbi.inTransaction(handle -> {
            // Get all screening ids related to the movie
            List<Long> screeningIds = handle.createQuery(qFindScreeningIds)
                    .bind(0, id)
                    .mapTo(Long.class)
                    .list();

            // Delete tickets related to each screening
            for (Long screeningId : screeningIds) {
                handle.createUpdate(qDeleteTickets)
                        .bind(0, screeningId)
                        .execute();
            }

            // Delete screenings related to the movie
            handle.createUpdate(qDeleteScreenings)
                    .bind(0, id)
                    .execute();

            // Delete theater_movie entries related to the movie
            handle.createUpdate(qDeleteTheaterMovie)
                    .bind(0, id)
                    .execute();

            // Delete the movie itself
            int count = handle.createUpdate(qDeleteMovie)
                    .bind(0, id)
                    .execute();

            return count > 0;
        });
    }


    public static void main(String[] args) {
        MovieDaoImpl m = new MovieDaoImpl();
        System.out.println(m.deleteMovieById(142l));
    }
}
