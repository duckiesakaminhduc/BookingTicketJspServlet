package com.bookingticket.controller.config;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.lang.reflect.Array;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

public class CustomPrincipal implements Principal {
    private String username;
    private String password;
    private List<String> roles;

    public CustomPrincipal(String username, String password, String... roles) {
        this.username = username;
        this.password = password;
        this.roles = Arrays.asList(roles);
    }

    @Override
    public String getName() {
        return username;
    }

    public boolean isUserInRole(String role) {
        return roles.contains(role);
    }
}
