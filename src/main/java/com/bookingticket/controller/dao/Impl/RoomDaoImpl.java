package com.bookingticket.controller.dao.Impl;

import com.bookingticket.controller.dao.RoomDao;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.dto.RoomDto;
import com.bookingticket.controller.mapper.RoomDtoMapper;
import org.jdbi.v3.core.Jdbi;

public class RoomDaoImpl implements RoomDao {
    Jdbi jdbi;

    public RoomDaoImpl() {
        this.jdbi = Database.getJdbi();
        jdbi.registerRowMapper(new RoomDtoMapper());
    }

    @Override
    public RoomDto getRoom(Long screening_id) {
        String q = "select r.id,r.room_name,r.theater_id from screening s  " +
                "join screening_room sr on s.id = sr.screening_id " +
                "join room r on r.id = sr.room_id " +
                "where s.id = ? " +
                "limit 1";
        return jdbi.withHandle(handle -> {
            return handle.createQuery(q)
                    .bind(0, screening_id)
                    .mapTo(RoomDto.class)
                    .findOnly();
        });
    }

    public static void main(String[] args) {
        RoomDao r =new RoomDaoImpl();
        System.out.println(r.getRoom(72l));
    }
}
