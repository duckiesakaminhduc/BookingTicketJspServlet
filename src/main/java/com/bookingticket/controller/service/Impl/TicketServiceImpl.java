package com.bookingticket.controller.service.Impl;

import com.bookingticket.controller.dao.Impl.TicketDaoImpl;
import com.bookingticket.controller.dao.TicketDao;
import com.bookingticket.controller.dto.TicketDto;
import com.bookingticket.controller.service.TicketService;

import java.time.LocalDateTime;
import java.util.List;

public class TicketServiceImpl implements TicketService {
    TicketDao ticketDao;

    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = new TicketDaoImpl();
    }

    @Override
    public boolean addTicket(LocalDateTime create_at, Long user_id, Long room_id, Long combo_id, Long screening_id, float total_price, Long theater_id, Long movie_id) {
        return ticketDao.addTicket(create_at,user_id,room_id,combo_id,screening_id,total_price,theater_id,movie_id);
    }

    @Override
    public List<TicketDto> getAllTicket(Long user_id) {
        return ticketDao.getAllTicket(user_id);
    }
}
