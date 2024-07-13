package com.bookingticket.controller.controller.ScreeningController;

import com.bookingticket.controller.dao.Impl.ScreeningDaoImpl;
import com.bookingticket.controller.dao.ScreeningDao;
import com.bookingticket.controller.dto.ScreeningDto;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@WebServlet(urlPatterns = "/admin/screening")
public class ScreeningAdd extends HttpServlet {
    ScreeningDao screeningDao;
    ScreeningService screeningService;

    public ScreeningAdd() {
        this.screeningDao = new ScreeningDaoImpl();
        this.screeningService = new ScreeningServiceImpl(screeningDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
        List<Map<String, String>> screenings = gson.fromJson(jsonObject.get("screenings"), List.class);

        List<ScreeningDto> screeningDtos = new ArrayList<>();

        screenings.forEach(item -> {
            ScreeningDto screeningDto = new ScreeningDto();
            item.forEach((key, value) -> {
                switch (key) {
                    case "day":
                        LocalTime currentTime = LocalTime.now();
                        int hour = currentTime.getHour();
                        int minute = currentTime.getMinute();
                        int currentYear = LocalDate.now().getYear();
                        String[] parts = value.split("-");
                        int day = Integer.parseInt(parts[0]);
                        int month = Integer.parseInt(parts[1]);
                        LocalDateTime time = LocalDateTime.of(currentYear, month, day, hour, minute);
//                        System.out.println("day" + value);
                        screeningDto.setDay(time);
                        break;
                    case "start_at":
                        LocalTime start_at = LocalTime.parse(value);
//                        System.out.println("start_at" +start_at);
                        screeningDto.setStart_at(start_at);
                        break;
                    case "movie_id":
                        Long movie_id = Long.parseLong(value);
//                        System.out.println("movie_id :" + movie_id);
                        screeningDto.setMovie_id(movie_id);
                        break;
                    case "td_id":
                        int td_id = Integer.parseInt(value);
                        screeningDto.setTd_id(td_id);
                }
            });
            screeningDtos.add(screeningDto);
        });
        screeningDtos.forEach(item -> {
            screeningService.insertScreening(item);
        });
        System.out.println(screeningDtos.toString());

    }
}
