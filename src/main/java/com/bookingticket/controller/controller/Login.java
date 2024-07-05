package com.bookingticket.controller.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {
    private static final Logger logger = Logger.getLogger(Login.class.getName());

    static{
        try{
            // Tạo file handler để ghi log vào file
            FileHandler fileHandler = new FileHandler("login-servlet.log",true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            logger.log(Level.SEVERE,"Failed to initialize log file handler",e);
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.log(Level.INFO,"GET request received for/login");
        logger.log(Level.INFO,"minh ne!");
        logger.log(Level.INFO,"hoainam nè!!");
//        System.out.println("minh ne!");
//        System.out.println("hoainam nè!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.log(Level.INFO,"POST request received for/login");
        logger.log(Level.INFO,"minh ne!");
        logger.log(Level.INFO,"hoainam nè!!");
//        System.out.println("minh ne!");
//        System.out.println("hoainam nè!!!");
    }
}
