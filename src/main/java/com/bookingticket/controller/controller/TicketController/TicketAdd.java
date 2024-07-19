package com.bookingticket.controller.controller.TicketController;


import com.bookingticket.controller.dao.Impl.TicketDaoImpl;
import com.bookingticket.controller.dao.TicketDao;
import com.bookingticket.controller.dto.TicketSingleton;
import com.bookingticket.controller.service.Impl.TicketServiceImpl;
import com.bookingticket.controller.service.TicketService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/addTicket")
public class TicketAdd extends HttpServlet {
    TicketDao ticketDao;
    TicketService ticketService;

    public TicketAdd() {
        this.ticketDao = new TicketDaoImpl();
        this.ticketService = new TicketServiceImpl(ticketDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TicketSingleton t = TicketSingleton.getInstance();
        LocalDateTime localDateTime = LocalDateTime.now();
        Long user_id = t.getUser_id();
        Long room_id = t.getRoom_id();
        Long screening_id = t.getScreening_id();
        Long movie_id = t.getMovie_id();
        Long theater_id = 1l;
        Long combo_id = 1l;
        Float total_price = (float) t.getTotal_price();
        boolean re = ticketService.addTicket(localDateTime, user_id, room_id, combo_id, screening_id, total_price, theater_id, movie_id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
        System.out.println(re);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
