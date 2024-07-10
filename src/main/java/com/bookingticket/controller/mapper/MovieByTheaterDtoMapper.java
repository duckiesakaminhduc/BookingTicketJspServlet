package com.bookingticket.controller.mapper;

import com.bookingticket.controller.dto.MovieByTheaterDto;
import com.bookingticket.controller.dto.MovieDto;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieByTheaterDtoMapper implements RowMapper<MovieByTheaterDto> {

    @Override
    public MovieByTheaterDto map(ResultSet rs, StatementContext ctx) throws SQLException {
        MovieByTheaterDto movieDto = new MovieByTheaterDto();
        movieDto.setMovie_id(rs.getLong("id"));
        movieDto.setMovie_name(rs.getString("movie_name"));
        movieDto.setCreate_at(rs.getTimestamp("create_at"));
        movieDto.setCreate_by(rs.getString("create_by"));
        movieDto.setModified_at(rs.getTimestamp("modified_at"));
        movieDto.setModified_by(rs.getString("modified_by"));
        movieDto.setUrl_img(rs.getString("url_img"));
        movieDto.setStatus(rs.getInt("status"));
        return movieDto;
    }
}
