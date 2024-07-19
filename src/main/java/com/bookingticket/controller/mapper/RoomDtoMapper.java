package com.bookingticket.controller.mapper;

import com.bookingticket.controller.dto.RoomDto;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDtoMapper implements RowMapper<RoomDto> {
    @Override
    public RoomDto map(ResultSet rs, StatementContext ctx) throws SQLException {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(rs.getLong("id"));
        roomDto.setRoom_name(rs.getString("room_name"));
        roomDto.setTheater_id(rs.getLong("theater_id"));
        return roomDto;
    }
}
