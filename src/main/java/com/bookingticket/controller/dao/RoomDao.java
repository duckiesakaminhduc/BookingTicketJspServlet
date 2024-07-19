package com.bookingticket.controller.dao;

import com.bookingticket.controller.dto.RoomDto;
import org.jdbi.v3.core.Jdbi;

public interface RoomDao {
    public RoomDto getRoom(Long screening_id);
}
