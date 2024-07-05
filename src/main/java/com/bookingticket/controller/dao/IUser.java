package com.bookingticket.controller.dao;

import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.model.User;
import org.jdbi.v3.core.Jdbi;

public interface IUser {

    public boolean register(User user);
}
