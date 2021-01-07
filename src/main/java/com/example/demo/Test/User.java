package com.example.demo.Test;

import java.sql.Timestamp;

public class User {
    private String user_email;
    private String user_password;
    private Integer user_count;
    private Timestamp user_last_login_time;

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getUser_count() {
        return user_count;
    }

    public void setUser_count(Integer user_count) {
        this.user_count = user_count;
    }

    public Timestamp getUser_last_login_time() {
        return user_last_login_time;
    }

    public void setUser_last_login_time(Timestamp user_last_login_time) {
        this.user_last_login_time = user_last_login_time;
    }

    public User() {
    }

    public User(String user_email, String user_password, Integer user_count, Timestamp user_last_login_time) {
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_count = user_count;
        this.user_last_login_time = user_last_login_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_email='" + user_email + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_count=" + user_count +
                ", user_last_login_time=" + user_last_login_time +
                '}';
    }
}
