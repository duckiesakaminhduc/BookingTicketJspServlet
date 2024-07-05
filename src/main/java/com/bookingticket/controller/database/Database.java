package com.bookingticket.controller.database;

import org.jdbi.v3.core.Jdbi;

public class Database {
    private static String URL = "jdbc:mysql://localhost:3306/booking_ticket";
    private static String USER = "root";
    private static String PASS = "root";
    private static org.jdbi.v3.core.Jdbi jdbi;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            jdbi = org.jdbi.v3.core.Jdbi.create(URL, USER, PASS);
            System.out.println("Connect Success");
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Fail");
        }
    }

    public static org.jdbi.v3.core.Jdbi getJdbi() {
        return jdbi;
    }

}
