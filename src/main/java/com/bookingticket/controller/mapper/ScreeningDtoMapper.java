package com.bookingticket.controller.mapper;

import com.bookingticket.controller.dto.ScreeningDto;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ScreeningDtoMapper implements RowMapper<ScreeningDto> {
    @Override
    public ScreeningDto map(ResultSet rs, StatementContext ctx) throws SQLException {
        ScreeningDto screeningDto = new ScreeningDto();
        screeningDto.setId(rs.getLong("id"));
        screeningDto.setDay(rs.getObject("day", LocalDateTime.class));
        screeningDto.setStart_at(rs.getObject("start_at", LocalTime.class));
        screeningDto.setMovie_id(rs.getLong("movie_id"));

        return screeningDto;
    }
}

