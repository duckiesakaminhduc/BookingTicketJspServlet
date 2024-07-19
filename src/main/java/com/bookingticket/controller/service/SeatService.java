package com.bookingticket.controller.service;

import com.bookingticket.controller.dto.SeatDto;

import java.util.List;

public interface SeatService {
    public boolean createSeat(String seat_name, Long room_id, Long screening_id);
    public List<SeatDto> getAllSeats(Long screening_id, Long room_id);
}
