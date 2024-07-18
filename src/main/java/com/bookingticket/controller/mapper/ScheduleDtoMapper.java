package com.bookingticket.controller.mapper;

import com.bookingticket.controller.dto.ScheduleDto;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleDtoMapper implements RowMapper<ScheduleDto> {
    @Override
    public ScheduleDto map(ResultSet rs, StatementContext ctx) throws SQLException {
        ScheduleDto scheduleDto = new ScheduleDto();
//        scheduleDto.setDay(rs.getString("day"));
        scheduleDto.setTheater_name(rs.getString("theater_name"));
        scheduleDto.setTime(rs.getString("time"));
        scheduleDto.setScreening_id(rs.getLong("screening_id"));
        return scheduleDto;
    }
}
