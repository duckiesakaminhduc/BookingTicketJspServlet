package com.bookingticket.controller.admin;

import com.Log.AbstractLogger;

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
    private static final AbstractLogger logger = new AbstractLogger(HomeController.class.getName(),"admin-home.log"){};


    {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Ghi Log cho request GET
        logger.info("Received GET request from: " + req.getRemoteAddr());

        // Xử lý request Get
        resp.getWriter().write("GET request processed");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Ghi Log cho request POST
        logger.info("Received POST request from: " + req.getRemoteAddr());

        // Xử lý request Post
        resp.getWriter().write("POST request processed");

    }
}
