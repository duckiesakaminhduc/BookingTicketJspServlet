package com.bookingticket.controller.dao.Impl;

import com.bookingticket.controller.dao.TicketDao;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.dto.TicketDto;
import com.bookingticket.controller.mapper.TicketDtoMapper;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.time.LocalDateTime;
import java.util.List;

public class TicketDaoImpl implements TicketDao {
    Jdbi jdbi;

    public TicketDaoImpl() {
        this.jdbi = Database.getJdbi();
        jdbi.registerRowMapper(new TicketDtoMapper());
    }

    @Override
    public boolean addTicket(LocalDateTime create_at, Long user_id, Long room_id, Long combo_id, Long screening_id, float total_price, Long theater_id, Long movie_id) {
        String sql = "INSERT INTO ticket (create_at, user_id, room_id, combo_id, screening_id, total_price, theater_id, movie_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Handle handle = jdbi.open()) {
            // Thực hiện câu lệnh INSERT
            int rowsAffected = handle.createUpdate(sql)
                    .bind(0, create_at)
                    .bind(1, user_id)
                    .bind(2, room_id)
                    .bind(3, combo_id)
                    .bind(4, screening_id)
                    .bind(5, total_price)
                    .bind(6, theater_id)
                    .bind(7, movie_id)
                    .execute();

            // Kiểm tra nếu ít nhất một hàng bị ảnh hưởng
            return rowsAffected > 0;
        } catch (Exception e) {
            // Xử lý lỗi nếu có
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<TicketDto> getAllTicket(Long user_id) {
        String q = "Select * from ticket where user_id = ?";
        return jdbi.withHandle(handle -> {
           return handle.createQuery(q)
                    .bind(0,user_id)
                    .mapTo(TicketDto.class)
                    .list();
        });
    }

    public static void main(String[] args) {
        TicketDao t = new TicketDaoImpl();
//        System.out.println(t.addTicket(LocalDateTime.now(), 2l, 10l, 1l, 51l, 2322323, 1l, 3l));
        ;
        System.out.println(t.getAllTicket(2l));
    }
}
