package com.bookingticket.controller.dao;

import com.bookingticket.controller.dto.MovieByTheaterDto;
import com.bookingticket.controller.dto.MovieDto;
import com.bookingticket.controller.dto.RevenueByTheaterDto;
import com.bookingticket.controller.mapper.MovieDtoMapper;

import java.util.List;

public interface TheaterDao {
    public List<RevenueByTheaterDto> RevenueByTicket(int x1, List<String> x2);

    public List<MovieByTheaterDto> getAllMovieByTheater(String theater);

}
