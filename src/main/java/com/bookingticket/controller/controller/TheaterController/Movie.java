package com.bookingticket.controller.controller.TheaterController;

import com.bookingticket.controller.dao.Impl.TheaterDaoImpl;
import com.bookingticket.controller.dao.TheaterDao;
import com.bookingticket.controller.dto.MovieByTheaterDto;
import com.bookingticket.controller.service.Impl.TheaterServiceImpl;
import com.bookingticket.controller.service.TheaterService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/theater"})
public class Movie extends HttpServlet {
    TheaterService theaterService;
    TheaterDao theaterDao;

    public Movie() {
        this.theaterDao = new TheaterDaoImpl();
        this.theaterService = new TheaterServiceImpl(theaterDao);
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String theater_name = "CINESTAR SINH VIÊN";
        List<MovieByTheaterDto> movies = theaterService.getAllMovieByTheater(theater_name);

        Gson gson = new Gson();
        String jsonArray = gson.toJson(movies);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonArray.toString());
    }
}
