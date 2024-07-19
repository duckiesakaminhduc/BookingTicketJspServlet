package com.bookingticket.controller.controller.SeatController;

import com.bookingticket.controller.dao.Impl.SeatDaoImpl;
import com.bookingticket.controller.dao.SeatDao;
import com.bookingticket.controller.dto.SeatDto;
import com.bookingticket.controller.service.Impl.SeatServiceImpl;
import com.bookingticket.controller.service.SeatService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/getSeats")
public class SeatGetAll extends HttpServlet {
    SeatDao seatDao;
    SeatService seatService;

    public SeatGetAll() {
        this.seatDao = new SeatDaoImpl();
        this.seatService = new SeatServiceImpl(seatDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long screening_id = Long.valueOf(req.getParameter("screening_id"));
        Long room_id = Long.valueOf(req.getParameter("room_id"));
        List<SeatDto> seats = seatService.getAllSeats(screening_id, room_id);

        JsonObject jsonResponse = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        seats.forEach(item -> {
            JsonObject j = new JsonObject();
            j.addProperty("id", item.getId());
            j.addProperty("seat_name", item.getSeat_name());
            j.addProperty("state", item.getState());
            j.addProperty("screening_id", item.getScreening_id());
            jsonArray.add(j);
        });
        jsonResponse.add("data", jsonArray);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse.toString());
    }
}
