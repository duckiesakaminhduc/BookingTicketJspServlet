package com.bookingticket.controller.config;

import com.Log.AbstractLogger;

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


public class CustomPrincipal extends AbstractLogger implements Principal {
    private String username;
    private String password;

    private List<String> roles;

    private static final Logger logger = Logger.getLogger("CustomPrincipal.class.getName");

    public CustomPrincipal(String username, String password, String... roles) {
        super(CustomPrincipal.class.getName(), "customer-principal.log");
        this.username = username;
        this.password = password;
        this.roles = Arrays.asList(roles);
        info("Created Custom Principal for user: " + username + " with roles: " + String.join(",", roles));

    }

    @Override
    public String getName() {
        info("getName() called for user: " + username);
        return username;
    }


    public boolean isUserInRole(String role) {
        boolean result = roles.contains(role);
        info("isUserInRole() called for user " + username + " with role: " + role + " result: " + result);
        return result;
    }
}
