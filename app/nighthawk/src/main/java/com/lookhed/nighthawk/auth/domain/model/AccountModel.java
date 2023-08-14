package com.lookhed.nighthawk.auth.domain.model;

public class AccountModel {
    private int id;
    private String username;
    private String password;
    private int user_id;

    public AccountModel(int id, String username, String password, int user_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
