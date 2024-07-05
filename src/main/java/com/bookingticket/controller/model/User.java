package com.bookingticket.controller.model;


import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.List;

public class User extends AbstractModel<User> {
    @ColumnName("username")
    private String username;
    @ColumnName("email")
    private String email;
    @ColumnName("password")
    private String password;
    @ColumnName("status")
    private int status;

    private List<String> roles;

    @Override
    public List<String> getRoles() {
        return roles;
    }

    @Override
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public User(String username, String email, String password, int status, List<String> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.roles = roles;
    }

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

    public User(String username, String email, String password, int status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
    }
}
