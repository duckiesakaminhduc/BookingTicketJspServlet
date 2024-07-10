package com.bookingticket.controller.controller.MovieController;

import com.bookingticket.controller.dao.Impl.MovieDaoImpl;
import com.bookingticket.controller.dao.MovieDao;
import com.bookingticket.controller.dto.MovieEditDto;
import com.bookingticket.controller.service.Impl.MovieServiceImpl;
import com.bookingticket.controller.service.MovieService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/movie")
public class Movie extends HttpServlet {
    MovieService movieService;
    MovieDao movieDao;

    public Movie() {
        this.movieDao = new MovieDaoImpl();
        this.movieService = new MovieServiceImpl(movieDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long movie_id = Long.valueOf(req.getParameter("movie_id"));
        Gson gson = new Gson();
        MovieEditDto movieEditDto = movieService.getMovieById(movie_id);
        System.out.println(movieEditDto.toString());
        String movieJson = gson.toJson(movieEditDto);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(movieJson);
    }
}
