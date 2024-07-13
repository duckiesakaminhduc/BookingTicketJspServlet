package com.bookingticket.controller.service.Impl;

import com.bookingticket.controller.dao.Impl.ScreeningDaoImpl;
import com.bookingticket.controller.dao.ScreeningDao;
import com.bookingticket.controller.dto.ScreeningDto;
import com.bookingticket.controller.dto.ScreeningGetDto;
import com.bookingticket.controller.service.ScreeningService;

import java.util.List;

public class ScreeningServiceImpl implements ScreeningService {
    ScreeningDao screeningDao;

    public ScreeningServiceImpl(ScreeningDao screeningDao) {
        this.screeningDao = new ScreeningDaoImpl();
    }

    @Override
    public boolean insertScreening(ScreeningDto screeningDto) {
        return screeningDao.insertScreening(screeningDto);
    }

    @Override
    public List<ScreeningGetDto> getScreenings(Long theater_id, Long room_id) {
        return screeningDao.getScreenings(theater_id,room_id);
    }
}
