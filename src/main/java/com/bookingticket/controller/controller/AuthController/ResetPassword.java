package com.bookingticket.controller.controller.AuthController;

import com.bookingticket.controller.config.AuthConfig.EmailUtility;
import com.bookingticket.controller.config.AuthConfig.UpdatableBCrypt;
import com.bookingticket.controller.dao.Impl.UserDaoImpl;
import com.bookingticket.controller.dao.UserDao;
import com.bookingticket.controller.service.Impl.UserServiceImp;
import com.bookingticket.controller.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/forgot")
public class ResetPassword extends HttpServlet {
    private UserService userService;
    private UserDao userDao;

    public ResetPassword() {
        this.userDao = new UserDaoImpl();
        this.userService = new UserServiceImp(userDao);

    }

    private String host;
    private String port;
    private String user;
    private String pass;
    UpdatableBCrypt updatableBCrypt = new UpdatableBCrypt();

    private RandomUtils randomUtils = new RandomUtils();

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        String recipient = request.getParameter("email");
        String subject = request.getParameter("subject");
//        set new pass into db
        String newPass = RandomStringUtils.randomAlphabetic(10);
        userService.resetPassword(recipient, newPass);

        String content = "The new e-mail is: " + newPass;
        String resultMessage = "The e-mail was sent successfully";

        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    content);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/views/result_forgot.jsp").forward(
                    request, response);
        }
    }
}
