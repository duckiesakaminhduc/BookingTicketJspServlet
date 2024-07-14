package com.bookingticket.controller.dao.Impl;

import com.bookingticket.controller.dao.ScreeningDao;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.dto.ScreeningByMovieDto;
import com.bookingticket.controller.dto.ScreeningDto;
import com.bookingticket.controller.dto.ScreeningGetDto;
import com.bookingticket.controller.mapper.ScreeningByMovieDtoMapper;
import com.bookingticket.controller.mapper.ScreeningDtoMapper;
import com.bookingticket.controller.mapper.ScreeningGetDtoMapper;
import org.jdbi.v3.core.Jdbi;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ScreeningDaoImpl implements ScreeningDao {
    private Jdbi jdbi;

    public ScreeningDaoImpl() {
        this.jdbi = Database.getJdbi();
        jdbi.registerRowMapper(new ScreeningDtoMapper());
        jdbi.registerRowMapper(new ScreeningGetDtoMapper());
        jdbi.registerRowMapper(new ScreeningByMovieDtoMapper());
    }

//    @Override
//    public boolean insertScreening(ScreeningDto screeningDto) {
//        String q = "Insert into screening(day,start_at,movie_id,td_id) values(?,?,?,?)";
//        int re = jdbi.withHandle(handle -> {
//            return handle.createUpdate(q)
//                    .bind(0, screeningDto.getDay())
//                    .bind(1, screeningDto.getStart_at())
//                    .bind(2, screeningDto.getMovie_id())
//                    .bind(3, screeningDto.getTd_id())
//                    .execute();
//        });
//        return re > 0;
//    }

    @Override
    public boolean insertScreening(ScreeningDto screeningDto, Long room_id) {
        String q = "Insert into screening(day, start_at, movie_id, td_id) values (?, ?, ?, ?)";
        String q1 = "Insert into screening_room(screening_id, room_id) values (?, ?)";

        int count = jdbi.inTransaction(handle -> {
            int screening_id = handle.createUpdate(q)
                    .bind(0, screeningDto.getDay())
                    .bind(1, screeningDto.getStart_at())
                    .bind(2, screeningDto.getMovie_id())
                    .bind(3, screeningDto.getTd_id())
                    .executeAndReturnGeneratedKeys("screening_id")
                    .mapTo(Integer.class)
                    .findOnly();

            return handle.createUpdate(q1)
                    .bind(0, screening_id)
                    .bind(1, room_id)
                    .execute();
        });

        return count > 0;
    }


    @Override
    public List<ScreeningGetDto> getScreenings(Long theater_id, Long room_id) {
        String q = "SELECT s.id as screening_id,m.id as movie_id, DATE_FORMAT(s.`day`,'%d-%m') as `day`,TIME_FORMAT(s.start_at,'%h-%m') as start_at,m.url_img,m.duration,s.td_id FROM `screening` s " +
                "join screening_room sr on sr.screening_id  = s.id " +
                "join room r on r.id = sr.room_id " +
                "join theater t on t.id = r.theater_id " +
                "join movie m on m.id = s.movie_id " +
                "where t.id = ? and r.id = ?";

        List<ScreeningGetDto> list = new ArrayList<>();
        list = jdbi.withHandle(handle -> {
            return handle.createQuery(q)
                    .bind(0, theater_id)
                    .bind(1, room_id)
                    .mapTo(ScreeningGetDto.class)
                    .list();
        });
        return list;
    }

    @Override
    public List<ScreeningByMovieDto> getScreeningsByMovieId(Long id) {
        String q = "SELECT s.id, DATE_FORMAT(s.`day`, '%d/%m') AS day, DAYNAME(s.`day`) AS day_of_week " +
                "FROM screening s " +
                "JOIN movie m ON m.id = s.movie_id " +
                "JOIN theater_movie tm ON tm.movie_id = m.id " +
                "where m.id = ?; ";
        return jdbi.withHandle(handle -> {
            return handle.createQuery(q)
                    .bind(0, id)
                    .mapTo(ScreeningByMovieDto.class)
                    .list();
        });
    }

    public static void main(String[] args) {
        ScreeningDao screeningDao = new ScreeningDaoImpl();
        ScreeningDto screeningDto = new ScreeningDto(24l,
                LocalDateTime.of(2024, 7, 15, 14, 0),
                LocalTime.of(14, 0), 3l, 1);

//        System.out.println(screeningDao.insertScreening(screeningDto, 1l));
//        System.out.println(screeningDao.getScreenings(3l, 11l).toString());
        System.out.println(screeningDao.getScreeningsByMovieId(1l));
    }
}
