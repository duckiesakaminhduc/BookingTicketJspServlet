//package com.bookingticket.controller.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter("/admin/test")
//public class AdminFitler implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        HttpSession ss = req.getSession();
//        String role = (String) ss.getAttribute("role");
//        String token = (String) ss.getAttribute("token");
//
//        if (token != null && role.equals("ADMIN")) {
//            chain.doFilter(request, response);
//        } else {
//            resp.sendRedirect( req.getContextPath()+ "/views/login.jsp");
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
