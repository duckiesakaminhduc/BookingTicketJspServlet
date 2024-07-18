package com.bookingticket.controller.dao;

public interface SeatDao {
    public boolean createSeat(String seat_name, Long room_id, Long screening_id);
}
