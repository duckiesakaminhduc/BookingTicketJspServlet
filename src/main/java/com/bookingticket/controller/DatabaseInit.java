package com.bookingticket.controller;

import com.bookingticket.controller.config.AuthConfig.UpdatableBCrypt;
import com.bookingticket.controller.database.Database;
import org.jdbi.v3.core.Jdbi;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DatabaseInit implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UpdatableBCrypt updatableBCrypt = new UpdatableBCrypt();
        String password  = updatableBCrypt.hash("123");
        Jdbi jdbi = Database.getJdbi();
        String q = "Select count(*) from user u join role r on u.id = r.user_id where r.name ='ADMIN' ";
        String q1 = "Insert into user(username,email,password,status) values(?,?,?,?)";
        String q2 = "Insert into role(name,user_id) values(?,?)";
        jdbi.useHandle(handle -> {
            int users = handle
                    .createQuery(q).mapTo(Integer.class).findOnly();
            System.out.println(users);
            if (users == 0) {
                {
                    int id = handle.createUpdate(q1)
                            .bind(0,"ADMIN")
                            .bind(1,"ADMIN@GMAIL.COM")
                            .bind(2,password)
                            .bind(3,1)
                            .executeAndReturnGeneratedKeys("id")
                            .mapTo(Integer.class)
                            .findOnly();

                    int re1 = handle.createUpdate(q2)
                            .bind(0,"ADMIN")
                            .bind(1,id).execute();

                    System.out.println(re1);
                }
            }
        });
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}