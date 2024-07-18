package com.bookingticket.controller.controller.ScreeningController;

import com.bookingticket.controller.dao.Impl.ScreeningDaoImpl;
import com.bookingticket.controller.dao.ScreeningDao;
import com.bookingticket.controller.dto.ScreeningByMovieDto;
import com.bookingticket.controller.service.Impl.ScreeningServiceImpl;
import com.bookingticket.controller.service.ScreeningService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/movie/screening")
public class ScreeningGetByMovieId extends HttpServlet {
    ScreeningDao screeningDao;
    ScreeningService screeningService;

    public ScreeningGetByMovieId() {
        this.screeningDao = new ScreeningDaoImpl();
        this.screeningService = new ScreeningServiceImpl(screeningDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long movie_id = Long.valueOf(req.getParameter("movie_id"));
        List<ScreeningByMovieDto> list = screeningService.getScreeningsByMovieId(movie_id);

        req.setAttribute("screenings", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/movie_detail.jsp");
        dispatcher.forward(req, resp);

        System.out.println("dang torng servlet");
    }
}
