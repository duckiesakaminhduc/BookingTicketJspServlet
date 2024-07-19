package com.bookingticket.controller.mapper;

import com.bookingticket.controller.dto.TicketDto;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TicketDtoMapper implements RowMapper<TicketDto> {
    @Override
    public TicketDto map(ResultSet rs, StatementContext ctx) throws SQLException {
        // Tạo một đối tượng TicketDto mới
        TicketDto ticketDto = new TicketDto();

        // Ánh xạ các cột trong ResultSet đến thuộc tính của TicketDto
        ticketDto.setId(rs.getLong("id"));
        ticketDto.setCreate_at(rs.getObject("create_at", LocalDateTime.class));
        ticketDto.setModified_at(rs.getObject("modified_at", LocalDateTime.class));
        ticketDto.setCreate_by(rs.getString("create_by"));
        ticketDto.setModified_by(rs.getString("modified_by"));
        ticketDto.setUser_id(rs.getLong("user_id"));
        ticketDto.setRoom_id(rs.getLong("room_id"));
        ticketDto.setCombo_id(rs.getLong("combo_id"));
        ticketDto.setScreening_id(rs.getLong("screening_id"));
        ticketDto.setTotal_price(rs.getFloat("total_price"));
        ticketDto.setTheater_id(rs.getLong("theater_id"));
        ticketDto.setMovie_id(rs.getLong("movie_id"));

        // Trả về đối tượng TicketDto đã được ánh xạ
        return ticketDto;
    }
}
