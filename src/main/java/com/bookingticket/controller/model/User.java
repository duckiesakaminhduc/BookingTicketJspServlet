package com.bookingticket.controller.model;


import java.util.List;

public class User extends AbstractModel<User> {
    private String username;
    private String email;
    private String password;

    private List<String> roles;
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

    @Override
    public List<String> getRoles() {
        return roles;
    }

    @Override
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User(String username, String email, String password, List<String> roles, int status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.status = status;
    }
}
