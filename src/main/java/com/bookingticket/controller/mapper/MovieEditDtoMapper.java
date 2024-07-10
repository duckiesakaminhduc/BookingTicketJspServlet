package com.bookingticket.controller.mapper;

import com.bookingticket.controller.dto.MovieDto;
import com.bookingticket.controller.dto.MovieEditDto;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieEditDtoMapper implements RowMapper<MovieEditDto> {
    @Override
    public MovieEditDto map(ResultSet rs, StatementContext ctx) throws SQLException {
        MovieEditDto movieDto = new MovieEditDto();

        // Ánh xạ các cột từ ResultSet vào các thuộc tính của MovieDto
        movieDto.setCountry(rs.getString("country"));
        movieDto.setDuration(rs.getInt("duration"));
        movieDto.setManager(rs.getString("manager"));
        movieDto.setMovie_name(rs.getString("movie_name"));
        movieDto.setPerformers(rs.getString("performers"));
        movieDto.setPremiere(rs.getString("premiere"));
        movieDto.setRecommend(rs.getString("recommend"));
        movieDto.setSubtitle(rs.getString("subtitle"));
        movieDto.setUrl_img(rs.getString("url_img"));
        movieDto.setStatus(rs.getInt("status"));
        return movieDto;
    }
}
