package com.bookingticket.controller.controller.ScreeningController;

import com.bookingticket.controller.dao.Impl.ScreeningDaoImpl;
import com.bookingticket.controller.dao.ScreeningDao;
import com.bookingticket.controller.service.Impl.ScreeningServiceImpl;
import com.bookingticket.controller.service.ScreeningService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/screening")
public class ScreeningAdd extends HttpServlet {
    ScreeningDao screeningDao;
    ScreeningService screeningService;

    public ScreeningAdd() {
        this.screeningDao = new ScreeningDaoImpl();
        this.screeningService = new ScreeningServiceImpl(screeningDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("xin caho");
    }
}
