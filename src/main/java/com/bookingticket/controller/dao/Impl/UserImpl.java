package com.bookingticket.controller.dao.Impl;

import com.bookingticket.controller.dao.IUser;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.model.User;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.util.Optional;

public class UserImpl implements IUser {
    private Jdbi jdbi = Database.getJdbi();

    @Override
    public boolean register(User user) {
        String checkUserQuery = "SELECT COUNT(*) FROM user WHERE username = ?";
        String insertUserQuery = "INSERT INTO user(username, email, password, status) VALUES (?, ?, ?, ?)";
        String insertRoleQuery = "INSERT INTO role(name, user_id) VALUES ('USER', ?)";

        return jdbi.inTransaction(handle -> {
            int count = handle.createQuery(checkUserQuery)
                    .bind(0, user.getUsername())
                    .mapTo(Integer.class)
                    .findOnly();

            if (count == 0) {
                int userId = handle.createUpdate(insertUserQuery)
                        .bind(0, user.getUsername())
                        .bind(1, user.getEmail())
                        .bind(2, user.getPassword())
                        .bind(3, user.getStatus())
                        .executeAndReturnGeneratedKeys("id")
                        .mapTo(Integer.class)
                        .findOnly();

                handle.createUpdate(insertRoleQuery)
                        .bind(0, userId)
                        .execute();

                return true;
            }

            return false;
        });
    }

    public static void main(String[] args) {
        new UserImpl().register(new User("minh", "minh@example.com", "password123", 1));
    }
}
