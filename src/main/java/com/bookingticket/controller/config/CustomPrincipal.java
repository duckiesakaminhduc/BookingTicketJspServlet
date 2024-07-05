package com.bookingticket.controller.config;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.lang.reflect.Array;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import java.io.IOException;


public class CustomPrincipal implements Principal {
    private String username;
    private String password;

    private List<String> roles;

    private static final Logger logger = Logger.getLogger("CustomPrincipal.class.getName");

    static {
        // Tạo file handler để ghi log vào file
        try {
            FileHandler fileHandler = new FileHandler("customer-principal.log",true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize log file handler", e);
        }
    }

    public CustomPrincipal(String username, String password, String... roles) {
        this.username = username;
        this.password = password;
        this.roles = Arrays.asList(roles);
        logger.log(Level.INFO,"Created Customer Principal for user : " + username + " with roles: " + String.join(",",roles));

    }

    @Override
    public String getName() {
        logger.log(Level.INFO,"getName() called for user: " + username);
        return username;
    }


    public boolean isUserInRole(String role) {
        boolean result = roles.contains(role);
        logger.log(Level.INFO,"isUserInRole() called for user" + username + "with role:" + role + "result : " + result) ;
        return result;
    }
}
