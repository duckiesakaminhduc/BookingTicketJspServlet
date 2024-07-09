package com.bookingticket.controller.mapper;

import com.bookingticket.controller.dto.MovieDto;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class MovieDtoMapper implements RowMapper<MovieDto> {
    @Override
    public MovieDto map(ResultSet rs, StatementContext ctx) throws SQLException {
        MovieDto movieDto = new MovieDto();

        // Ánh xạ các cột từ ResultSet vào các thuộc tính của MovieDto
        movieDto.setCreate_at(rs.getTime("create_at"));
        movieDto.setCreate_by(rs.getString("create_by"));
        movieDto.setModified_at(rs.getTime("modified_at"));
        movieDto.setModified_by(rs.getString("modified_by"));
        movieDto.setCategory(rs.getString("category"));
        movieDto.setCountry(rs.getString("country"));
        movieDto.setDuration(rs.getInt("duration"));
        movieDto.setFormat(rs.getString("format"));
        movieDto.setManager(rs.getString("manager"));
        movieDto.setMovie_name(rs.getString("movie_name"));
        movieDto.setPerformers(rs.getString("performers"));
        movieDto.setPremiere(rs.getString("premiere"));
        movieDto.setRecommend(rs.getString("recommend"));
        movieDto.setSubtitle(rs.getString("subtitle"));
        movieDto.setUrl_img(rs.getString("url_img"));
        movieDto.setStatus(rs.getInt("statsu"));
        return movieDto;
    }
}
