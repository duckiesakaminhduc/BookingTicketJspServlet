package com.bookingticket.controller.config.AuthConfig;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Random;


public class JwtUtils {
    private static final String jwtSecret = "Ym9hdGpvaW5wYXRobWlkZGxlZHJlYW13ZXJlYmVuZHJvYXJvbGRjb21lb2ZmZXJhZmy=";
    private static int ttlMillis = 86400000;

    private static String id = JwtUtils.randJIT();
    private static final String issuer = "ducminh";
    private static String subject;

    private static String randJIT() {
        StringBuilder result = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int charactersLength = characters.length();
        Random random = new Random();
        for (int counter = 0; counter < 15; counter++) {
            result.append(characters.charAt(random.nextInt(charactersLength)));
        }
        return result.toString();
    }

    public static String createJWT(String subject) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtSecret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    public static Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
        return claims;
    }

    public static void main(String[] args) {
        String a = JwtUtils.createJWT("USER");
        System.out.println(a);
//        System.out.println(JwtUtils.id);
//        System.out.println(JwtUtils.decodeJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJtaHJBZnVZR1paSDhPRm4iLCJpYXQiOjE3MjAxODYwNTAsInN1YiI6IkJvb2tpbmdUaWNrZXQiLCJpc3MiOiJkdWNtaW5oIiwiZXhwIjoxNzIwMjcyNDUwfQ.D9ghSl-uupzPXK_tw0MQnZ23dT7uTy2AT6bY4IxOFBA"));
    }
}
