package com.bookingticket.controller.dao;

import com.bookingticket.controller.dto.RevenueByTheaterDto;

import java.util.List;

public interface TheaterDao {
    public List<RevenueByTheaterDto> RevenueByTicket();
}
