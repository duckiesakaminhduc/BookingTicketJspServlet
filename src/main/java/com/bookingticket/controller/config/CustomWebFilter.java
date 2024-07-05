package com.bookingticket.controller.config;

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
public class CustomWebFilter implements Filter {
    private static final Logger logger = Logger.getLogger(CustomWebFilter.class.getName());

     static{
         try{
             // Tạo file handler để ghi log vào file
             FileHandler fileHandler = new FileHandler("customer-web-filter.log",true);
             fileHandler.setFormatter(new SimpleFormatter());
             logger.addHandler(fileHandler);

         } catch (IOException e) {
             logger.log(Level.SEVERE,"Failed to initialize log file handler ",e);

         }
     }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         logger.log(Level.INFO,"Initializing Custom Web Filter");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        logger.log(Level.INFO,"Request URI " + req.getRequestURI());

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("ROLE") == null) {
            logger.log(Level.WARNING,"Unauthorized access attempt to: " + req.getRequestURI());
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        logger.log(Level.INFO,"Authorized access to:" + req.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.log(Level.INFO, "Destroying CustomWebFilter");

    }
}