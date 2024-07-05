package com.Log;

public class Login {
    private Logging logger = new LogbackLogger(Login.class);

    public boolean login(String username, String password) {
        // Kiểm tra logic đăng nhập ở đây
        boolean isAuthenticated = performAuthentication(username, password);

        // Ghi log
        if (isAuthenticated) {
            logger.info("User '{}' logged in successfully.", username);
        } else {
            logger.warn("Failed login attempt for user '{}'.", username);
        }

        return isAuthenticated;
    }

    private boolean performAuthentication(String username, String password) {
        // Ghi log xác thực đăng nhập
        return "admin".equals(username) && "password123".equals(password);
    }
}
