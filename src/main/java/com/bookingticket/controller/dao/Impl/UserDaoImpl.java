package com.bookingticket.controller.dao.Impl;

import com.bookingticket.controller.config.UpdatableBCrypt;
import com.bookingticket.controller.dao.UserDao;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.model.User;
import org.jdbi.v3.core.Jdbi;

public class UserDaoImpl implements UserDao {
    private Jdbi jdbi = Database.getJdbi();

    @Override
    public boolean register(User user) {
        String checkUserQuery = "SELECT COUNT(*) FROM user WHERE username = ?";
        String insertUserQuery = "INSERT INTO user(username, email, password, status) VALUES (?, ?, ?, ?)";
        String insertRoleQuery = "INSERT INTO role(name, user_id) VALUES ('USER', ?)";
        UpdatableBCrypt updatableBCrypt = new UpdatableBCrypt();
        return jdbi.inTransaction(handle -> {
            int count = handle.createQuery(checkUserQuery)
                    .bind(0, user.getUsername())
                    .mapTo(Integer.class)
                    .findOnly();

            if (count == 0) {
                int userId = handle.createUpdate(insertUserQuery)
                        .bind(0, user.getUsername())
                        .bind(1, user.getEmail())
                        .bind(2, updatableBCrypt.hash(user.getPassword()))
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

    @Override
    public void login(User user) {

    }

    public static void main(String[] args) {
        new UserDaoImpl().register(new User("minh", "minh@example.com", "password123", 1));
    }
}
