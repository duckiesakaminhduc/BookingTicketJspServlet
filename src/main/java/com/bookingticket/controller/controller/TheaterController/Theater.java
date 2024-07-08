package com.bookingticket.controller.controller.TheaterController;

import com.bookingticket.controller.dao.Impl.TheaterDaoImpl;
import com.bookingticket.controller.dao.TheaterDao;
import com.bookingticket.controller.dto.RevenueByTheaterDto;
import com.bookingticket.controller.service.Impl.TheaterServiceImpl;
import com.bookingticket.controller.service.TheaterService;
import com.google.api.client.json.Json;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/revenue")
public class Theater extends HttpServlet {
    TheaterService theaterService;
    TheaterDao theaterDao;

    public Theater() {
        this.theaterDao = new TheaterDaoImpl();
        this.theaterService = new TheaterServiceImpl(theaterDao);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RevenueByTheaterDto> revenue = theaterService.RevenueByTicket();
        Gson gson = new Gson();
        JsonArray jsonArray = gson.toJsonTree(revenue).getAsJsonArray();
//        System.out.println(jsonArray);


        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonArray.toString());

    }
}
