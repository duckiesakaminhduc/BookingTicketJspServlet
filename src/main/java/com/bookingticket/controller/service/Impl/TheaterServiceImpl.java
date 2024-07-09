package com.bookingticket.controller.service.Impl;

import com.bookingticket.controller.dao.TheaterDao;
import com.bookingticket.controller.dao.UserDao;
import com.bookingticket.controller.dto.MovieByTheaterDto;
import com.bookingticket.controller.dto.RevenueByTheaterDto;
import com.bookingticket.controller.service.TheaterService;

import java.util.List;

public class TheaterServiceImpl implements TheaterService {
    private TheaterDao theaterDao;

    public TheaterServiceImpl(TheaterDao theaterDao) {
        this.theaterDao = theaterDao;
    }


    @Override
    public List<RevenueByTheaterDto> RevenueByTicket(int x1, List<String> x2) {
        return theaterDao.RevenueByTicket(x1, x2);
    }

    @Override
    public List<MovieByTheaterDto> getAllMovieByTheater(String theater) {
        return theaterDao.getAllMovieByTheater(theater);
    }
}
