package com.bookingticket.controller.dao.Impl;

import com.bookingticket.controller.dao.ScheduleDao;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.dto.ScheduleDto;
import com.bookingticket.controller.dto.ScreeningDetail;
import com.bookingticket.controller.mapper.ScheduleDtoMapper;
import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleDaoImpl implements ScheduleDao {
    private Jdbi jdbi;

    public ScheduleDaoImpl() {
        this.jdbi = Database.getJdbi();
        jdbi.registerRowMapper(new ScheduleDtoMapper());
    }

    @Override
    public List<Map<String, List<ScreeningDetail>>> getSchedules(String day, Long movie_id) {
        String q = "select t.theater_name, s.id as screening_id, TIME_FORMAT(s.start_at,'%H:%i') as time from room r " +
                "join theater t on r.theater_id = t.id " +
                "join screening_room sr on sr.room_id = r.id " +
                "join screening s on s.id = sr.screening_id " +
                "join movie m on m.id = s.movie_id " +
                "where DATE_FORMAT(s.`day`,'%d/%m') = ? " +
                "and m.id = ?";

        List<ScheduleDto> schedules = jdbi.withHandle(handle ->
                handle.createQuery(q)
                        .bind(0, day)
                        .bind(1, movie_id)
                        .mapTo(ScheduleDto.class)
                        .list()
        );

        Map<String, List<ScreeningDetail>> scheduleMap = new HashMap<>();
        for (ScheduleDto schedule : schedules) {
            scheduleMap.computeIfAbsent(schedule.getTheater_name(), k -> new ArrayList<>())
                    .add(new ScreeningDetail(schedule.getScreening_id(), schedule.getTime()));
        }

        List<Map<String, List<ScreeningDetail>>> result = new ArrayList<>();
        result.add(scheduleMap);

        return result;
    }


    public static void main(String[] args) {
        ScheduleDao scheduleDao = new ScheduleDaoImpl();
        System.out.println(scheduleDao.getSchedules("17/07", 3l));
    }
}
