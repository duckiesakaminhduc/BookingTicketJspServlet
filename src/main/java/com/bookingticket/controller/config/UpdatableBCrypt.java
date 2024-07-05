package com.bookingticket.controller.config;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class UpdatableBCrypt {
    //    dang ki ghi log cho lop nay
    private static final Logger log = LoggerFactory.getLogger(UpdatableBCrypt.class);
    private final int logRounds = 12;

    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(logRounds));
    }

    public boolean veryfyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }


    public static void main(String[] args) {

        UpdatableBCrypt u = new UpdatableBCrypt();
        String pass = "123";
//        String hash = u.hash(pass);
//        System.out.println(hash);
        String hash = "$2a$12$zenMJ3S/gIVL.M4EJLbr6ueQAOr9k5dIozSIuDklQYM.fL4i9b2zy";
        System.out.println(u.veryfyHash(pass,hash));
    }
}