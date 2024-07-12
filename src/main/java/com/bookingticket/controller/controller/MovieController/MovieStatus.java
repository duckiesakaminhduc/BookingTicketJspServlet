package com.bookingticket.controller.controller.MovieController;

import com.bookingticket.controller.dao.Impl.MovieDaoImpl;
import com.bookingticket.controller.dao.MovieDao;
import com.bookingticket.controller.dto.MovieDto;
import com.bookingticket.controller.service.Impl.MovieServiceImpl;
import com.bookingticket.controller.service.MovieService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/movie/status")
public class MovieStatus extends HttpServlet {
    MovieService movieService;
    MovieDao movieDao;

    public MovieStatus() {
        this.movieDao = new MovieDaoImpl();
        this.movieService = new MovieServiceImpl(movieDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("xin chao");
        List<MovieDto> movies = movieService.getMoviesByStatus();
        Gson gson = new Gson();

        JsonObject jsonResponse = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        movies.forEach(item->{
            JsonObject j = new JsonObject();
            j.addProperty("id",item.getId());
            j.addProperty("movie_name",item.getMovie_name());
            j.addProperty("duration",item.getDuration());
            j.addProperty("url_img",item.getUrl_img());
            jsonArray.add(j);
        });
//        jsonResponse.add("data",jsonArray);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonArray.toString());
    }
}
