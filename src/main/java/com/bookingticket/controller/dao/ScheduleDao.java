package com.bookingticket.controller.dao;

import com.bookingticket.controller.dto.ScreeningDetail;

import java.util.List;
import java.util.Map;

public interface ScheduleDao {
    public List<Map<String, List<ScreeningDetail>>> getSchedules(String day, Long movie_id);
}
