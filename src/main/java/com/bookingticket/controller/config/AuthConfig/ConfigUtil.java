//package com.bookingticket.controller.config.AuthConfig;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//public class ConfigUtil {
//    private static Properties properties;
//
//    static {
//        properties = new Properties();
//        try {
//            InputStream input = ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties");
//            properties.load(input);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static String getProperty(String key) {
//        return properties.getProperty(key);
//    }
//}
