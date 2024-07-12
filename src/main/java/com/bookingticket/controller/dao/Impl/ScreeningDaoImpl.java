package com.bookingticket.controller.dao.Impl;

import com.bookingticket.controller.dao.ScreeningDao;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.dto.ScreeningDto;
import com.bookingticket.controller.mapper.ScreeningDtoMapper;
import org.jdbi.v3.core.Jdbi;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ScreeningDaoImpl implements ScreeningDao {
    private Jdbi jdbi;

    public ScreeningDaoImpl() {
        this.jdbi = Database.getJdbi();
        jdbi.registerRowMapper(new ScreeningDtoMapper());
    }

    @Override
    public boolean insertScreening(ScreeningDto screeningDto) {
        String q = "Insert into screening(day,start_at,movie_id) values(?,?,?)";
        int re = jdbi.withHandle(handle -> {
            return handle.createUpdate(q)
                    .bind(0, screeningDto.getDay())
                    .bind(1, screeningDto.getStart_at())
                    .bind(2, screeningDto.getMovie_id())
                    .execute();
        });
        return re > 0;
    }

    public static void main(String[] args) {
        ScreeningDao screeningDao = new ScreeningDaoImpl();
        ScreeningDto screeningDto = new ScreeningDto(
                LocalDateTime.of(2024, 7, 15, 14, 0),
                LocalTime.of(14, 0),
                1L
        );
        System.out.println(screeningDao.insertScreening(screeningDto));
    }
}
