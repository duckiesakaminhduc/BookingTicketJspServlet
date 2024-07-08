package com.bookingticket.controller.dao.Impl;

import com.bookingticket.controller.dao.TheaterDao;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.dto.RevenueByTheaterDto;
import com.bookingticket.controller.mapper.RevenueByTheaterDtoMapper;
import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.List;

public class TheaterDaoImpl implements TheaterDao {
    private Jdbi jdbi;

    public TheaterDaoImpl() {
        this.jdbi = Database.getJdbi();
        jdbi.registerRowMapper(new RevenueByTheaterDtoMapper());
    }

    @Override
    public List<RevenueByTheaterDto> RevenueByTicket() {
        List<RevenueByTheaterDto> revenus = new ArrayList<>();
        String q = "SELECT tt.theater_name,ROUND(SUM(tk.total_price),3) as total_price FROM theater tt " +
                "join ticket tk on tt.id = tk.theater_id " +
                "GROUP BY tt.theater_name";
        revenus = jdbi.withHandle(handle -> {
            return handle.createQuery(q)
                    .mapTo(RevenueByTheaterDto.class)
                    .list();
        });

        return revenus;
    }

    public static void main(String[] args) {
        TheaterDao t  = new TheaterDaoImpl();
        System.out.println(t.RevenueByTicket().toString());
    }
}
