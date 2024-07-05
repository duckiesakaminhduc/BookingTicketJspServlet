package com.bookingticket.controller.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import javax.servlet.ServletException;
import java.io.IOException;


public class CustomHttpServletRequest extends HttpServletRequestWrapper {
    public CustomHttpServletRequest(HttpServletRequest request) {
        super(request);
    }
    private static final Logger logger = Logger.getLogger(CustomHttpServletRequest.class.getName());

    static{
        try{
            //Tạo file handler để ghi log vào file
            FileHandler fileHandler = new FileHandler("customer-http-request.log",true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize log file handler", e);
        }
    }

    @Override
    public Principal getUserPrincipal() {
        Principal myUser = (Principal) getSession().getAttribute("USER");
        if(myUser == null){
            logger.log(Level.INFO, "Retrieved custom user principal: " + myUser.getName());
        }else{
            logger.log(Level.INFO, "Using default user principal: " + myUser.getName());
        }
        return myUser != null ? myUser : super.getUserPrincipal();
    }

    @Override
    public boolean isUserInRole(String role) {
        return getUserPrincipal() instanceof CustomPrincipal
                && ((CustomPrincipal) getUserPrincipal()).isUserInRole(role)
                || super.isUserInRole(role);
        //logger.log(Level.INFO,"Checking user role : " + role + "result" + result);
        //return result;
    }
}