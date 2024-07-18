package com.bookingticket.controller.controller.SeatController;

import com.bookingticket.controller.dao.Impl.SeatDaoImpl;
import com.bookingticket.controller.dao.SeatDao;
import com.bookingticket.controller.service.Impl.SeatServiceImpl;
import com.bookingticket.controller.service.SeatService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SeatAdd extends HttpServlet {
    SeatDao seatDao;
    SeatService seatService;

    public SeatAdd(SeatDao seatDao, SeatService seatService) {
        this.seatDao = new SeatDaoImpl();
        this.seatService = new SeatServiceImpl(seatDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String seat_name = req.getParameter("seat_name");
        Long room_id = Long.valueOf(req.getParameter("room_id"));
        Long screening_id = Long.valueOf(req.getParameter("screening_id"));

        Boolean re = seatService.createSeat(seat_name, room_id, screening_id);

    }
}
