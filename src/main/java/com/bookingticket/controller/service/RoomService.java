package com.bookingticket.controller.service;

import com.bookingticket.controller.dto.RoomDto;

public interface RoomService {
    public RoomDto getRoom(Long screening_id);
}
