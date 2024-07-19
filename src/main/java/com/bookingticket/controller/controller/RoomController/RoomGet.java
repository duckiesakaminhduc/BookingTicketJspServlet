package com.bookingticket.controller.controller.RoomController;

import com.bookingticket.controller.dao.Impl.RoomDaoImpl;
import com.bookingticket.controller.dao.RoomDao;
import com.bookingticket.controller.dto.RoomDto;
import com.bookingticket.controller.dto.TicketSingleton;
import com.bookingticket.controller.service.Impl.RoomServiceImpl;
import com.bookingticket.controller.service.RoomService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/room/screening_id")
public class RoomGet extends HttpServlet {
    RoomDao roomDao;
    RoomService roomService;

    public RoomGet() {
        this.roomDao = new RoomDaoImpl();
        this.roomService = new RoomServiceImpl(roomDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long screening_id = Long.valueOf(req.getParameter("screening_id"));
        RoomDto roomDto = roomService.getRoom(screening_id);
        Gson gson = new Gson();
        String json = gson.toJson(roomDto);
        TicketSingleton.getInstance().setRoom_id(roomDto.getId());
        TicketSingleton.getInstance().setScreening_id(screening_id);
        System.out.println(TicketSingleton.getInstance().toString());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
