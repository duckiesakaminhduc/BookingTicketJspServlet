package com.bookingticket.controller.service.Impl;

import com.bookingticket.controller.dao.UserDao;
import com.bookingticket.controller.model.User;
import com.bookingticket.controller.service.UserService;

public class UserServiceImp implements UserService {
    private UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean register(User user) {
        return userDao.register(user);
    }
}
