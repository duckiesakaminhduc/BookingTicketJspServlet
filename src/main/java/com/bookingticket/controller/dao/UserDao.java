package com.bookingticket.controller.dao;

import com.bookingticket.controller.model.User;

public interface UserDao {

    public boolean register(User user);

    public void login(User user);
}
