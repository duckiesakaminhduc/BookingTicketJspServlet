package com.bookingticket.controller.controller.ScheduleController;

import com.bookingticket.controller.dao.Impl.ScheduleDaoImpl;
import com.bookingticket.controller.dao.ScheduleDao;
import com.bookingticket.controller.dto.ScheduleDto;
import com.bookingticket.controller.dto.ScreeningDetail;
import com.bookingticket.controller.service.Impl.ScheduleServiceImpl;
import com.bookingticket.controller.service.ScheduleService;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/movie/schedule")
public class ScheduleGet extends HttpServlet {
    ScheduleDao scheduleDao;
    ScheduleService scheduleService;

    public ScheduleGet() {
        this.scheduleDao = new ScheduleDaoImpl();
        this.scheduleService = new ScheduleServiceImpl(scheduleDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String day = req.getParameter("day");
        Long movie_id = Long.valueOf(req.getParameter("movie_id"));
        List<Map<String, List<ScreeningDetail>>> scheduleDtos = scheduleService.getSchedules(day,movie_id);

        Gson gson = new Gson();
        String json = gson.toJson(scheduleDtos);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
