package com.bookingticket.controller.dao;

import com.bookingticket.controller.dto.SeatDto;

import java.util.List;

public interface SeatDao {
    public boolean createSeat(String seat_name, Long room_id, Long screening_id);

    public List<SeatDto> getAllSeats(Long screening_id, Long room_id);
}
