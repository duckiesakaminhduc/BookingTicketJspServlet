package com.bookingticket.controller.dao.Impl;

import com.bookingticket.controller.dao.SeatDao;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.mapper.SeatDtoMapper;
import org.jdbi.v3.core.Jdbi;

public class SeatDaoImpl implements SeatDao {
    Jdbi jdbi;

    public SeatDaoImpl() {
        this.jdbi = Database.getJdbi();
        jdbi.registerRowMapper(new SeatDtoMapper());
    }

    @Override
    public boolean createSeat(String seat_name, Long room_id, Long screening_id) {
        String q = "INSERT INTO seat(seat_name, state, room_id, screening_id) VALUES (?, 1, ?, ?)";
        int count = jdbi.withHandle(handle -> {
            return handle.createUpdate(q)
                    .bind(0, seat_name)
                    .bind(1, room_id)
                    .bind(2, screening_id)
                    .execute();
        });
        return count > 0;
    }

    public static void main(String[] args) {
        SeatDao seatDao = new SeatDaoImpl();
        System.out.println(seatDao.createSeat("A01", 1l, 1l));
        ;
    }
}