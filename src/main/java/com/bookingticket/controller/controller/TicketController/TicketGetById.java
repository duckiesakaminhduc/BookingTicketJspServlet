package com.bookingticket.controller.controller.TicketController;

import com.bookingticket.controller.dao.Impl.TicketDaoImpl;
import com.bookingticket.controller.dao.TicketDao;
import com.bookingticket.controller.dto.TicketDto;
import com.bookingticket.controller.dto.TicketSingleton;
import com.bookingticket.controller.service.Impl.TicketServiceImpl;
import com.bookingticket.controller.service.TicketService;
import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user/ticket")
public class TicketGetById extends HttpServlet {
    TicketDao ticketDao;
    TicketService ticketService;

    public TicketGetById() {
        this.ticketDao = new TicketDaoImpl();
        this.ticketService = new TicketServiceImpl(ticketDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long user_id = TicketSingleton.getInstance().getUser_id();
//        Long user_id = Long.valueOf(req.getParameter("user_id"));
        List<TicketDto> tickets = ticketService.getAllTicket(user_id);

        JsonObject jsonRes = new JsonObject();

        Gson gson = Converters.registerAll(new GsonBuilder()).create();
        String json = gson.toJson(tickets);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json.toString());
        System.out.println(user_id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
