package com.example.demo.Test;

import java.sql.Timestamp;

public class Log {
    private Integer log_id ;
    private Timestamp log_login_time;
    private String user_email;

    public Log() {
    }

    public Log(Integer log_id, Timestamp log_login_time, String user_email) {
        this.log_id = log_id;
        this.log_login_time = log_login_time;
        this.user_email = user_email;
    }

    public Integer getLog_id() {
        return log_id;
    }

    public void setLog_id(Integer log_id) {
        this.log_id = log_id;
    }

    public Timestamp getLog_login_time() {
        return log_login_time;
    }

    public void setLog_login_time(Timestamp log_login_time) {
        this.log_login_time = log_login_time;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    @Override
    public String toString() {
        return "Log{" +
                "log_id=" + log_id +
                ", log_login_time=" + log_login_time +
                ", user_email='" + user_email + '\'' +
                '}';
    }
}
