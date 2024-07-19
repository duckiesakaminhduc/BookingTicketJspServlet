package com.bookingticket.controller.dao;

import com.bookingticket.controller.dto.UserDto;
import com.bookingticket.controller.model.User;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public boolean register(User user);

    boolean login(String username, String password);

    Map<String, List<String>> mapRoles(String username);

    public boolean resetPassword(String email,String password);

    public Long getUserId(String username);
}
