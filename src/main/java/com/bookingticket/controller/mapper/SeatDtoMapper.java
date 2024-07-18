package com.bookingticket.controller.mapper;

import com.bookingticket.controller.dto.SeatDto;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatDtoMapper implements RowMapper<SeatDto> {

    @Override
    public SeatDto map(ResultSet rs, StatementContext ctx) throws SQLException {
        SeatDto seatDto = new SeatDto();
        seatDto.setId(rs.getLong("id"));
        seatDto.setSeat_name((rs.getString("seat_name")));
        seatDto.setState(rs.getInt("state"));
        seatDto.setRoom_id(rs.getLong("room_id"));
        seatDto.setScreening_id(rs.getLong("screening_id"));
        return seatDto;
    }
}
