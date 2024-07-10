package com.bookingticket.controller.controller.TheaterController;

import com.bookingticket.controller.dao.Impl.TheaterDaoImpl;
import com.bookingticket.controller.dao.TheaterDao;
import com.bookingticket.controller.dto.MovieByTheaterDto;
import com.bookingticket.controller.service.Impl.TheaterServiceImpl;
import com.bookingticket.controller.service.TheaterService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@WebServlet(urlPatterns = {"/admin/theater"})
public class Movie extends HttpServlet {
    TheaterService theaterService;
    TheaterDao theaterDao;

    private int draw;
    private int start;
    private int length;
    private String search;
    private String orderColumn;
    private String orderDir;

    public Movie() {
        this.theaterDao = new TheaterDaoImpl();
        this.theaterService = new TheaterServiceImpl(theaterDao);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        draw = Integer.parseInt(req.getParameter("draw"));
        start = Integer.parseInt(req.getParameter("start"));
        length = Integer.parseInt(req.getParameter("length"));
        search = req.getParameter("search[value]");
        orderColumn = req.getParameter("order[0][column]");
        orderDir = req.getParameter("order[0][dir]");

        String theater_name = "CINESTAR SINH VIÊN";
        List<MovieByTheaterDto> movies = theaterService.getAllMovieByTheater(theater_name);

        // Áp dụng bộ lọc nếu có
        List<MovieByTheaterDto> moviesFiltered = movies;
        if (search != null && !search.isEmpty()) {
            moviesFiltered = movies.stream()
                    .filter(movie -> movie.getMovie_name().toLowerCase().contains(search.toLowerCase()))
                    .collect(Collectors.toList());
        }

        // Áp dụng phân trang sau khi đã áp dụng bộ lọc
        List<MovieByTheaterDto> moviesPaginated = moviesFiltered.stream()
                .skip(start)
                .limit(length)
                .collect(Collectors.toList());



        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("draw", draw);
        jsonResponse.addProperty("recordsTotal", movies.size());
        jsonResponse.addProperty("recordsFiltered", movies.size());

        JsonArray jsonArray = new JsonArray();
        moviesPaginated.forEach(item -> {
            JsonObject j = new JsonObject();
            j.addProperty("id", item.getMovie_id());
            j.addProperty("movie_name", item.getMovie_name());
            j.addProperty("create_at", String.valueOf(item.getCreate_at()));
            j.addProperty("create_by", item.getCreate_by());
            j.addProperty("modified_at", String.valueOf(item.getModified_at()));
            j.addProperty("modified_by", item.getModified_by());
            j.addProperty("status", item.getStatus());
            jsonArray.add(j);
        });


        jsonResponse.add("data", jsonArray);
        Gson gson = new Gson();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse.toString());
    }


    public static void main(String[] args) {

    }
}
