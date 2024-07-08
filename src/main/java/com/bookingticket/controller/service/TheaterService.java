package com.bookingticket.controller.service;

import com.bookingticket.controller.dto.RevenueByTheaterDto;

import java.util.List;

public interface TheaterService {
    public List<RevenueByTheaterDto> RevenueByTicket(int x1, List<String> x2);

}
