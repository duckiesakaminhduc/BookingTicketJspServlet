package com.bookingticket.controller.controller;

import com.Log.AbstractLogger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {
    private static class LoginLogger extends AbstractLogger {
        public LoginLogger() {
            super(Login.class.getName(), "login-servlet.log");
        }
    }

    private static final LoginLogger logger = new LoginLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("GET request received for /login");
        logger.info("minh ne!");
        logger.info("hoainam nè!!");
        // System.out.println("minh ne!");
        // System.out.println("hoainam nè!!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("POST request received for /login");
        logger.info("minh ne!");
        logger.info("hoainam nè!!");
        // System.out.println("minh ne!");
        // System.out.println("hoainam nè!!!");
    }
}
