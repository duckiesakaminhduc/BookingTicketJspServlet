package com.bookingticket.controller.service;

import com.bookingticket.controller.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public boolean register(User user);
    boolean login(String username,String password);
    Map<String, List<String>> mapRoles(String username);
    public boolean resetPassword(String email, String password);
}
