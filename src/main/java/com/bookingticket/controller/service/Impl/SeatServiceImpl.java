package com.bookingticket.controller.service.Impl;

import com.bookingticket.controller.dao.Impl.SeatDaoImpl;
import com.bookingticket.controller.dao.SeatDao;
import com.bookingticket.controller.dto.SeatDto;
import com.bookingticket.controller.service.SeatService;

import java.util.List;

public class SeatServiceImpl implements SeatService {
    SeatDao seatDao;

    public SeatServiceImpl(SeatDao seatDao) {
        this.seatDao = new SeatDaoImpl();
    }

    @Override
    public boolean createSeat(String seat_name, Long room_id, Long screening_id) {
        return seatDao.createSeat(seat_name, room_id, screening_id);
    }

    @Override
    public List<SeatDto> getAllSeats(Long screening_id, Long room_id) {
        return seatDao.getAllSeats(screening_id,room_id);
    }
}
