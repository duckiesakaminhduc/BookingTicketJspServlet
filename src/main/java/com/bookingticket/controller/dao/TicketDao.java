package com.bookingticket.controller.dao;

import com.bookingticket.controller.dto.TicketDto;
import org.jdbi.v3.core.Jdbi;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketDao {

    public boolean addTicket(LocalDateTime create_at, Long user_id, Long room_id, Long combo_id, Long screening_id, float total_price, Long theater_id, Long movie_id);

    public List<TicketDto> getAllTicket(Long user_id);
}
