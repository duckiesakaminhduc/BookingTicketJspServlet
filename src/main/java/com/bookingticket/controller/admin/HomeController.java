package com.bookingticket.controller.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;


@WebServlet(urlPatterns = {"/admin-home"})
public class HomeController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(HomeController.class.getName());

    static {
        try{
            // Tạo file handler để ghi log vào file
            FileHandler fileHandler = new FileHandler("admin-home.log",true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize log file handler", e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Ghi Log cho request GET
        logger.log(Level.INFO, "Received GET request from: " + req.getRemoteAddr());

        // Xử lý request Get



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Ghi Log cho request POST
        logger.log(Level.INFO, "Received POST request from: " + req.getRemoteAddr());
        //Xử lý request Post

    }
}
