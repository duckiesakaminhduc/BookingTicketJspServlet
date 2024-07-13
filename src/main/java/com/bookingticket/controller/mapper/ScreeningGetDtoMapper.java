package com.bookingticket.controller.mapper;

import com.bookingticket.controller.dto.ScreeningGetDto;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ScreeningGetDtoMapper implements RowMapper<ScreeningGetDto> {
    @Override
    public ScreeningGetDto map(ResultSet rs, StatementContext ctx) throws SQLException {
        ScreeningGetDto screeningDto = new ScreeningGetDto();
        screeningDto.setScreening_id(rs.getLong("screening_id"));
        screeningDto.setMovie_id(rs.getLong("movie_id"));
        screeningDto.setDay(rs.getString("day"));
        screeningDto.setStart_at(rs.getString("start_at"));
        screeningDto.setUrl_img(rs.getString("url_img"));
        screeningDto.setDuration(rs.getInt("duration"));
        screeningDto.setTd_id(rs.getInt("td_id"));
        return screeningDto;
    }
}

