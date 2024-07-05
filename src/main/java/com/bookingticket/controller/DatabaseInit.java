package com.bookingticket.controller;

import com.bookingticket.controller.database.Database;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import javax.management.Query;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@WebListener
public class DatabaseInit implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Jdbi jdbi = Database.getJdbi();
        String q = "Select count(*) from user u join role r on u.id = r.user_id where r.name ='ADMIN' ";
        String q1 = "Insert into user(username,email,password,status) values('amin','admin@gmail.com','123',1)";
        String q2 = "Insert into role(name,user_id) values('ADMIN',last_insert_id() )";
        jdbi.useHandle(handle -> {
            int users = handle
                    .createQuery(q).mapTo(Integer.class).findOnly();
            System.out.println(users);
            if (users == 0) {
                {
                    int re = handle.execute(q1);
                    int re1 = handle.execute(q2);
                    System.out.println(re1);
                }
            }
        });
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}