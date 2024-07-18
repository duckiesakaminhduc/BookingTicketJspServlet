package com.bookingticket.controller.mapper;

import com.bookingticket.controller.dto.ScreeningByMovieDto;
import com.bookingticket.controller.dto.ScreeningDto;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ScreeningByMovieDtoMapper implements RowMapper<ScreeningByMovieDto> {
    @Override
    public ScreeningByMovieDto map(ResultSet rs, StatementContext ctx) throws SQLException {
        ScreeningByMovieDto screeningDto = new ScreeningByMovieDto();
        screeningDto.setDay(rs.getString("day"));
        screeningDto.setDay_of_week(rs.getString("day_of_week"));
        return screeningDto;
    }
}
