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


}