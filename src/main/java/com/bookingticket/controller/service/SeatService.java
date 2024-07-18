package com.bookingticket.controller.service;

public interface SeatService {
    public boolean createSeat(String seat_name, Long room_id, Long screening_id);
}
