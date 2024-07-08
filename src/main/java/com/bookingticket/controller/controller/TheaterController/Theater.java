package com.bookingticket.controller.controller.TheaterController;

import com.bookingticket.controller.dao.Impl.TheaterDaoImpl;
import com.bookingticket.controller.dao.TheaterDao;
import com.bookingticket.controller.dto.RevenueByTheaterDto;
import com.bookingticket.controller.service.Impl.TheaterServiceImpl;
import com.bookingticket.controller.service.TheaterService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

        String months = jsonObject.get("months").getAsString();
        List<String> theaters = gson.fromJson(jsonObject.get("theaters"), List.class);
        int thang = 0;
        switch (months) {
            case "Tháng này":
                thang = 0;
                break;
            case "Tháng trước":
                thang = 1;
                break;
            case "6 Tháng":
                thang = 5;
                break;
            default:
        }
        List<RevenueByTheaterDto> revenue = theaterService.RevenueByTicket(thang, theaters);
        JsonArray jsonArray = gson.toJsonTree(revenue).getAsJsonArray();
        System.out.println(jsonArray.toString());
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonArray.toString());
    }
}
