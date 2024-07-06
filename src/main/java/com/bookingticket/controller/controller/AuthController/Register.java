package com.bookingticket.controller.controller.AuthController;

import com.bookingticket.controller.dao.Impl.UserDaoImpl;
import com.bookingticket.controller.dao.UserDao;
import com.bookingticket.controller.model.User;
import com.bookingticket.controller.service.Impl.UserServiceImp;
import com.bookingticket.controller.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet {
    private UserService userService;
    private UserDao userDao;

    public Register() {
        this.userDao = new UserDaoImpl();
        this.userService = new UserServiceImp(userDao);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(username, email, password, 1);
        boolean re = userService.register(user);
        System.out.println("Ket qa dki:" + re);
    }
}
