package com.bookingticket.controller.controller.ScreeningController;

import com.bookingticket.controller.dao.Impl.ScreeningDaoImpl;
import com.bookingticket.controller.dao.ScreeningDao;
import com.bookingticket.controller.dto.ScreeningGetDto;
import com.bookingticket.controller.service.Impl.ScreeningServiceImpl;
import com.bookingticket.controller.service.ScreeningService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/getScreening")
public class ScreeningGet extends HttpServlet {
    ScreeningDao screeningDao;
    ScreeningService screeningService;

    public ScreeningGet() {
        this.screeningDao = new ScreeningDaoImpl();
        this.screeningService = new ScreeningServiceImpl(screeningDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(reader,JsonObject.class);


        Long theater_id = jsonObject.get("theater_id").getAsLong();
        Long room_id = jsonObject.get("room_id").getAsLong();
        System.out.println("dang trong get screeenig");
        List<ScreeningGetDto> list = screeningService.getScreenings(theater_id,room_id);
        System.out.println(list.toString());

        String json = gson.toJson(list);

        // Cấu hình response và gửi JSON về client
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);



    }
}
