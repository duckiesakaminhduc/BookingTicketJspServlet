package com.bookingticket.controller.controller.AuthController;

import com.bookingticket.controller.config.AuthConfig.CustomHttpServletRequest;
import com.bookingticket.controller.config.AuthConfig.CustomPrincipal;
import com.bookingticket.controller.config.AuthConfig.JwtUtils;
import com.bookingticket.controller.dao.Impl.UserDaoImpl;
import com.bookingticket.controller.dao.UserDao;
import com.bookingticket.controller.service.Impl.UserServiceImp;
import com.bookingticket.controller.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {
    private UserService userService;
    private UserDao userDao;
    private String role;

    public Login() {
        this.userDao = new UserDaoImpl();
        this.userService = new UserServiceImp(userDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ss = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        List<String> roles = userService.mapRoles(username).get(username);
        boolean re = userService.login(username, password);
        if (re == true) {
            CustomPrincipal principal = new CustomPrincipal(username, password, roles);
            HttpServletRequest request = new CustomHttpServletRequest(req, principal);
//            System.out.println(request.isUserInRole("ADMIN"));
            if (request.isUserInRole("ADMIN")) {

            }
            role = request.isUserInRole("ADMIN") ? "ADMIN" : "USER";

            ss.setAttribute("token", JwtUtils.createJWT(role));
            ss.setAttribute("role", role);
            ss.setAttribute("username", username);
            System.out.println(role);

            req.setAttribute("username", username);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/getUserId");
            dispatcher.forward(req, resp);
        } else {
            System.out.println("sai thong tin dang nhap");
            resp.sendRedirect("views/login.jsp");
        }

        String re1 = (String) ss.getAttribute("token");
        System.out.println(re1);

    }
}
