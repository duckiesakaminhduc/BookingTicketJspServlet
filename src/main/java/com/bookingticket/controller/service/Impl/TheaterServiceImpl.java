package com.bookingticket.controller.service.Impl;

import com.bookingticket.controller.dao.TheaterDao;
import com.bookingticket.controller.dao.UserDao;
import com.bookingticket.controller.dto.RevenueByTheaterDto;
import com.bookingticket.controller.service.TheaterService;

import java.util.List;

public class TheaterServiceImpl implements TheaterService {
    private TheaterDao theaterDao;

    public TheaterServiceImpl(TheaterDao theaterDao) {
        this.theaterDao = theaterDao;
    }

    @Override
    public List<RevenueByTheaterDto> RevenueByTicket() {
        return theaterDao.RevenueByTicket();
    }
}
