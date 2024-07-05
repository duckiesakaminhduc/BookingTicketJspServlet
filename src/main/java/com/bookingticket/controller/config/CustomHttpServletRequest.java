package com.bookingticket.controller.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;

public class CustomHttpServletRequest extends HttpServletRequestWrapper {
    public CustomHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Principal getUserPrincipal() {
        Principal myUser = (Principal) getSession().getAttribute("USER");
        return myUser != null ? myUser : super.getUserPrincipal();
    }

    @Override
    public boolean isUserInRole(String role) {
        return getUserPrincipal() instanceof CustomPrincipal
                && ((CustomPrincipal) getUserPrincipal()).isUserInRole(role)
                || super.isUserInRole(role);
    }
}