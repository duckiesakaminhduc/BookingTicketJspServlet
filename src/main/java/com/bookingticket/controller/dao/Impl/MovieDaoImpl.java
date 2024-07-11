package com.bookingticket.controller.dao.Impl;

import com.bookingticket.controller.dao.MovieDao;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.dto.MovieDto;
import com.bookingticket.controller.dto.MovieEditDto;
import com.bookingticket.controller.mapper.MovieEditDtoMapper;
import io.vavr.Tuple3;
import io.vavr.collection.Seq;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.generic.GenericType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public boolean addMovie(MovieDto movieDto) {
        String sql = "INSERT INTO movie (create_at, create_by, modified_at, modified_by, category, country, duration, format, manager, movie_name, performers, premiere, recommend, subtitle, url_img, status) " +
                "VALUES (:create_at, :create_by, :modified_at, :modified_by, :category, :country, :duration, :format, :manager, :movie_name, :performers, :premiere, :recommend, :subtitle, :url_img, :status)";


        int re = jdbi.withHandle(handle -> {
            return handle.createUpdate(sql)
                    .bindBean(movieDto)
                    .execute();
        });
        return re > 0;
    }

    @Override
    public List<MovieDto> getMoviesByStatus() {
        String q = "SELECT id,duration,url_img FROM `movie` where status = 2";
        List<MovieDto> re = new ArrayList<>();
        re = jdbi.withHandle(handle -> {
            return handle.createQuery(q)
                    .mapToBean(MovieDto.class)
                    .list();
        });
        return re;
    }


    public static void main(String[] args) {
        MovieDaoImpl m = new MovieDaoImpl();
        System.out.println(m.getMoviesByStatus().toString());
    }
}
