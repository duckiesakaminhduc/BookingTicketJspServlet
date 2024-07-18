package com.bookingticket.controller.service;

import com.bookingticket.controller.dto.ScreeningDetail;

import java.util.List;
import java.util.Map;

public interface ScheduleService {
    public List<Map<String, List<ScreeningDetail>>> getSchedules(String day, Long movie_id);
}
