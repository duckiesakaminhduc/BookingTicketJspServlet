package com.bookingticket.controller.dao.Impl;

import com.bookingticket.controller.dao.TheaterDao;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.dto.MovieByTheaterDto;
import com.bookingticket.controller.dto.MovieDto;
import com.bookingticket.controller.dto.RevenueByTheaterDto;
import com.bookingticket.controller.mapper.MovieByTheaterDtoMapper;
import com.bookingticket.controller.mapper.MovieDtoMapper;
import com.bookingticket.controller.mapper.RevenueByTheaterDtoMapper;
import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.List;

public class TheaterDaoImpl implements TheaterDao {
    private Jdbi jdbi;

    public TheaterDaoImpl() {
        this.jdbi = Database.getJdbi();
        jdbi.registerRowMapper(new RevenueByTheaterDtoMapper());
        jdbi.registerRowMapper(new MovieDtoMapper());
        jdbi.registerRowMapper(new MovieByTheaterDtoMapper());
    }

    @Override
    public List<RevenueByTheaterDto> RevenueByTicket(int x1, List<String> x2) {
        List<RevenueByTheaterDto> revenus = new ArrayList<>();
        String q = "SELECT t.theater_name, ROUND(SUM(tk.total_price), 3) AS total_price, MONTH(s.`day`) AS `month` " +
                "FROM ticket tk " +
                "JOIN screening s ON s.id = tk.screening_id " +
                "JOIN theater t ON t.id = tk.theater_id " +
                "WHERE (MONTH(CURRENT_DATE) - MONTH(s.`day`) <= :x1) " +
                "AND (MONTH(CURRENT_DATE) >= MONTH(s.`day`)) " +
                "AND t.theater_name IN (<x2>) " +
                "GROUP BY t.theater_name, MONTH(s.`day`) " +
                "ORDER BY MONTH(s.`day`)";
        revenus = jdbi.withHandle(handle -> {
            return handle.createQuery(q)
                    .bind("x1", x1)
                    .bindList("x2", x2)
                    .mapTo(RevenueByTheaterDto.class)
                    .list();
        });

        return revenus;
    }

    @Override
    public List<MovieByTheaterDto> getAllMovieByTheater(String theater_name) {
        List<MovieByTheaterDto> movies = new ArrayList<>();
        String q = "select m.movie_name,m.create_at,m.create_by,m.modified_at,m.modified_by,m.url_img, m.status from movie m " +
                "join theater_movie tm on m.id = tm.movie_id  " +
                "join theater t on t.id = tm.theater_id " +
                "where t.theater_name = :theater_name ";
        movies = jdbi.withHandle(handle -> {
            return handle.createQuery(q)
                    .bind("theater_name", theater_name)
                    .mapTo(MovieByTheaterDto.class)
                    .list();
        });
        return movies;
    }

    public static void main(String[] args) {
        TheaterDao t = new TheaterDaoImpl();
        System.out.println(t.getAllMovieByTheater("CINESTAR SINH VIÊN").toString());
    }
}
