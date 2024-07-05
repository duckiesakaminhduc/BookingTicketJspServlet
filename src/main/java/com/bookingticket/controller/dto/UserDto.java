package com.bookingticket.controller.dto;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class UserDto {
    @ColumnName("username")
    private String username;
    @ColumnName("email")
    private String email;
    @ColumnName("password")
    private String password;
    @ColumnName("status")
    private int status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserDto(String username, String email, String password, int status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }

    public UserDto() {
    }
}
