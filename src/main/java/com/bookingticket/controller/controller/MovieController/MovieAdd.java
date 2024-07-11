package com.bookingticket.controller.controller.MovieController;

import com.bookingticket.controller.config.CloudinaryConfig.CloudinaryConfig;
import com.bookingticket.controller.dao.Impl.MovieDaoImpl;
import com.bookingticket.controller.dao.MovieDao;
import com.bookingticket.controller.dto.MovieDto;
import com.bookingticket.controller.service.Impl.MovieServiceImpl;
import com.bookingticket.controller.service.MovieService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.servlet.annotation.MultipartConfig;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Map;


@MultipartConfig
@WebServlet(urlPatterns = "/admin/addmovie")
public class MovieAdd extends HttpServlet {
    MovieService movieService;
    MovieDao movieDao;

    Cloudinary cloudinary = CloudinaryConfig.cloudinary;
    String re_url;

    public MovieAdd() {
        this.movieDao = new MovieDaoImpl();
        this.movieService = new MovieServiceImpl(movieDao);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String movie_name = req.getParameter("movie_name");
        String status = req.getParameter("status");
        String country = req.getParameter("country");
        String duration = req.getParameter("duration");
        String manager = req.getParameter("manager");
        String actor = req.getParameter("actor");
        String recommend = req.getParameter("recommend");
        String premiere = req.getParameter("premiere");
        String img_url = req.getParameter("img_url");

        System.out.println(status);
//        if (movie_name == null || status == null || fileUrl == null || country == null || duration == null ||
//                manager == null || actor == null || recommend == null || premiere == null) {
//            throw new ServletException("Some parameters are missing");
//        }

        int stt = 0;
        switch (status) {
            case "none":
                stt = 0;
                break;
            case "yes":
                stt = 1;
                break;
            case "no":
                stt = 2;
                break;
            default:
                throw new ServletException("Invalid status value");
        }

        MovieDto movieDto = new MovieDto();
        movieDto.setMovie_name(movie_name);
        movieDto.setStatus(stt);
        movieDto.setUrl_img(img_url);
        movieDto.setCountry(country);
        movieDto.setDuration(Integer.parseInt(duration));
        movieDto.setManager(manager);
        movieDto.setPerformers(actor);
        movieDto.setRecommend(recommend);
        movieDto.setPremiere(premiere);
        System.out.println(movieDto.toString());
        movieService.addMovie(movieDto);
    }


}

