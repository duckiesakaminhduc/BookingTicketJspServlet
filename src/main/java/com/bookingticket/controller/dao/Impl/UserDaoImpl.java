package com.bookingticket.controller.dao.Impl;

import com.bookingticket.controller.config.UpdatableBCrypt;
import com.bookingticket.controller.dao.UserDao;
import com.bookingticket.controller.database.Database;
import com.bookingticket.controller.dto.UserDto;
import com.bookingticket.controller.model.User;
import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public boolean login(String username, String password) {
        UpdatableBCrypt updatableBCrypt = new UpdatableBCrypt();
        List<UserDto> users = jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM user WHERE username = :username")
                    .bind("username", username)
                    .mapToBean(UserDto.class)
                    .list();
        });

        if (users.size() > 0) {
            String hash = users.get(0).getPassword();
            return updatableBCrypt.veryfyHash(password, hash) ? true : false;
        }
        return false;
    }

    @Override
    public Map<String, List<String>> mapRoles(String username) {
        Map<String, List<String>> map = new HashMap<>();
        String q = "Select r.name from user u join role r where r.user_id = u.id and u.username = ?";
        List<String> roles = jdbi.withHandle(handle -> {
            return handle.createQuery(q)
                    .bind(0,username)
                    .mapTo(String.class)
                    .list();
        });
        map.put(username, roles);
        return map;
    }


    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        Map<String, List<String>> re = userDao.mapRoles("minh");
        boolean re1 = userDao.login("minh","123");
//        System.out.println(re.toString());
        System.out.println(re1);
    }

}

