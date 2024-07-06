package com.bookingticket.controller.config;

import com.Log.AbstractLogger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;


@WebFilter("/trang-chu")
public class CustomWebFilter extends AbstractLogger implements Filter {
    public CustomWebFilter() {
        super(CustomWebFilter.class.getName(), "customer-web-filter.log");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        info("Initializing Custom Web Filter");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        info("Request URI: " + req.getRequestURI());

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("ROLE") == null) {
            warn("Unauthorized access attempt to: " + req.getRequestURI());
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        info("Authorized access to: " + req.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        info("Destroying Custom Web Filter");

    }
}