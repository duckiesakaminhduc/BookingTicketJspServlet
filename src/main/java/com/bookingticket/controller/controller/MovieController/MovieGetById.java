package com.bookingticket.controller.controller.MovieController;

import com.bookingticket.controller.dao.Impl.MovieDaoImpl;
import com.bookingticket.controller.dao.Impl.ScreeningDaoImpl;
import com.bookingticket.controller.dao.MovieDao;
import com.bookingticket.controller.dao.ScreeningDao;
import com.bookingticket.controller.dto.MovieDto;
import com.bookingticket.controller.dto.ScreeningByMovieDto;
import com.bookingticket.controller.dto.TicketSingleton;
import com.bookingticket.controller.service.Impl.MovieServiceImpl;
import com.bookingticket.controller.service.Impl.ScreeningServiceImpl;
import com.bookingticket.controller.service.MovieService;
import com.bookingticket.controller.service.ScreeningService;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/movie/detail")
public class MovieGetById extends HttpServlet {
    MovieService movieService;
    MovieDao movieDao;
    ScreeningDao screeningDao;
    ScreeningService screeningService;

    public MovieGetById() {
        this.movieDao = new MovieDaoImpl();
        this.movieService = new MovieServiceImpl(movieDao);
        this.screeningDao = new ScreeningDaoImpl();
        this.screeningService = new ScreeningServiceImpl(screeningDao);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long movie_id = Long.valueOf(req.getParameter("movie_id"));
        MovieDto movieDto = movieService.getMovieByMovie_ID(movie_id);

        List<ScreeningByMovieDto> list = screeningService.getScreeningsByMovieId(movie_id);

        req.setAttribute("movie_id", movie_id);
        req.setAttribute("screenings", list);
        req.setAttribute("movie", movieDto);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/movie_detail.jsp");
        dispatcher.forward(req, resp);

        TicketSingleton t = TicketSingleton.getInstance();
        t.setMovie_id(movieDto.getId());
        System.out.println(t.toString());
        System.out.println("Dang tỏng movie detail");

    }
}
