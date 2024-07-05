package com.bookingticket.controller.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;

public class CustomHttpServletRequest extends HttpServletRequestWrapper {
    private CustomPrincipal customPrincipal;

    public CustomHttpServletRequest(HttpServletRequest request, CustomPrincipal customPrincipal) {
        super(request);
        this.customPrincipal = customPrincipal;
    }

    @Override
    public Principal getUserPrincipal() {
        return this.customPrincipal;
    }

//    Phương thức isUserInRole() trả về true nếu người dùng là ở một role đã cho, trả về false nếu họ là không
    @Override
    public boolean isUserInRole(String role) {
        return this.customPrincipal.isUserInRole(role);
    }
}