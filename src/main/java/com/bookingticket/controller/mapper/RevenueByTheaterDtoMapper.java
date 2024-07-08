package com.bookingticket.controller.mapper;


import com.bookingticket.controller.dto.RevenueByTheaterDto;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RevenueByTheaterDtoMapper implements RowMapper<RevenueByTheaterDto> {
    @Override
    public RevenueByTheaterDto map(ResultSet rs, StatementContext ctx) throws SQLException {
        RevenueByTheaterDto dto = new RevenueByTheaterDto();
        dto.setTheater_name(rs.getString("theater_name"));
        dto.setTotal_price(rs.getFloat("total_price"));
        return dto;
    }
}
