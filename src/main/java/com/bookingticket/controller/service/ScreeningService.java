package com.bookingticket.controller.service;

import com.bookingticket.controller.dto.ScreeningDto;
import com.bookingticket.controller.dto.ScreeningGetDto;

import java.util.List;

public interface ScreeningService {
    public boolean insertScreening(ScreeningDto screeningDto, Long room_id);

    public List<ScreeningGetDto> getScreenings(Long theater_id, Long room_id);

}
