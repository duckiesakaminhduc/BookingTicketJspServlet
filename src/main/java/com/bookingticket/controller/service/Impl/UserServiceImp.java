package com.bookingticket.controller.service.Impl;

import com.bookingticket.controller.dao.UserDao;
import com.bookingticket.controller.model.User;
import com.bookingticket.controller.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImp implements UserService {
    private UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean register(User user) {
        return userDao.register(user);
    }

    @Override
    public boolean login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public Map<String, List<String>> mapRoles(String username) {
        return userDao.mapRoles(username);
    }

    @Override
    public boolean resetPassword(String email, String password) {
        return userDao.resetPassword(email,password);
    }
}
