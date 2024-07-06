package com.bookingticket.controller.config;

import com.Log.AbstractLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;

public class CustomHttpServletRequest extends HttpServletRequestWrapper {
    private static final AbstractLogger logger = new AbstractLogger(CustomHttpServletRequest.class.getName(), "customer-http-request.log") {};

    public CustomHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Principal getUserPrincipal() {
        Principal myUser = (Principal) getSession().getAttribute("USER");
        if (myUser != null) {
            logger.info("Retrieved custom user principal: " + myUser.getName());
        } else {
            logger.info("Using default user principal: " + getUserPrincipal().getName());
        }
        return myUser != null ? myUser : super.getUserPrincipal();
    }

    @Override
    public boolean isUserInRole(String role) {
        boolean result = getUserPrincipal() instanceof CustomPrincipal
                && ((CustomPrincipal) getUserPrincipal()).isUserInRole(role)
                || super.isUserInRole(role);
        logger.info("Checking user role: " + role + " result: " + result);
        return result;
    }
}
