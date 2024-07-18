package com.bookingticket.controller.service.Impl;

import com.bookingticket.controller.dao.Impl.ScheduleDaoImpl;
import com.bookingticket.controller.dao.MovieDao;
import com.bookingticket.controller.dao.ScheduleDao;
import com.bookingticket.controller.dto.ScreeningDetail;
import com.bookingticket.controller.service.ScheduleService;

import java.util.List;
import java.util.Map;

public class ScheduleServiceImpl implements ScheduleService {
    ScheduleDao scheduleDao;

    public ScheduleServiceImpl(ScheduleDao scheduleDao) {
        this.scheduleDao = new ScheduleDaoImpl();
    }

    @Override
    public List<Map<String, List<ScreeningDetail>>> getSchedules(String day, Long movie_id) {
        return scheduleDao.getSchedules(day,movie_id);
    }
}
