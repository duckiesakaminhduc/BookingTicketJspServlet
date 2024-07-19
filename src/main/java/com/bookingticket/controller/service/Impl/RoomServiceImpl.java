package com.bookingticket.controller.service.Impl;

import com.bookingticket.controller.dao.Impl.RoomDaoImpl;
import com.bookingticket.controller.dao.RoomDao;
import com.bookingticket.controller.dto.RoomDto;
import com.bookingticket.controller.service.RoomService;

public class RoomServiceImpl implements RoomService {
    RoomDao roomDao;

    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = new RoomDaoImpl();
    }

    @Override
    public RoomDto getRoom(Long screening_id) {
        return roomDao.getRoom(screening_id);
    }
}
