package com.bookingticket.controller.controller.MovieController;

import com.bookingticket.controller.dao.Impl.MovieDaoImpl;
import com.bookingticket.controller.dao.MovieDao;
import com.bookingticket.controller.service.Impl.MovieServiceImpl;
import com.bookingticket.controller.service.MovieService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/delete/movie")
public class MovieDelete extends HttpServlet {

    MovieService movieService;
    MovieDao movieDao;

    public MovieDelete() {
        this.movieDao = new MovieDaoImpl();
        this.movieService = new MovieServiceImpl(movieDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long movie_id = Long.valueOf(req.getParameter("movie_id"));
        movieService.deleteMovieById(movie_id);
    }
}
