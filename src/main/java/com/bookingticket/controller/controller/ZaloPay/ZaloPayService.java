package com.bookingticket.controller.controller.ZaloPay;

import com.bookingticket.controller.dto.TicketSingleton;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/create_ticket")
public class ZaloPayService extends HttpServlet {
    private CreateOrder createOrder = new CreateOrder();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ss = req.getSession();
        int amount = Integer.parseInt(req.getParameter("amount"));
        System.out.println("amount" + amount);
        String app_user = req.getParameter("app_user");
//        String app_user = String.valueOf(ss.getAttribute("username"));

        String description = req.getParameter("description");
        TicketSingleton.getInstance().setTotal_price(amount);
//        String item = req.getParameter("item");
        try {
//            JSONObject jsonObjectResult = CreateOrder.createOrderTicket(amount, app_user, description);
            JSONObject jsonObjectResult = CreateOrder.createOrderTicket(amount, app_user, description);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(jsonObjectResult.toString());
        } catch (Exception e) {
            resp.getWriter().write("Error" + e);
        }

//        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/ticket.jsp");
//        dispatcher.forward(req,resp);
//        resp.sendRedirect("/views/admin/ticket.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
