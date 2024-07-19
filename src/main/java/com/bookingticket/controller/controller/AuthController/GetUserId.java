package com.bookingticket.controller.controller.AuthController;

import com.bookingticket.controller.dao.Impl.UserDaoImpl;
import com.bookingticket.controller.dao.UserDao;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.dto.TicketSingleton;
import com.bookingticket.controller.dto.UserDto;
import com.bookingticket.controller.service.Impl.UserServiceImp;
import com.bookingticket.controller.service.UserService;
import org.jdbi.v3.core.Jdbi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/getUserId")
public class GetUserId extends HttpServlet {
    UserDao userDao;
    UserService userService;

    public GetUserId() {
        this.userDao = new UserDaoImpl();
        this.userService = new UserServiceImp(userDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getAttribute("username");
        Long user_id = userService.getUserId(username);
        TicketSingleton t  = TicketSingleton.getInstance();
        t.setUser_id(user_id);
        System.out.println(t.toString());

        // Chuyển tiếp đến trang JSP hoặc thực hiện hành động khác
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}

