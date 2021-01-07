package com.example.demo.domain;

import java.sql.*;

public class User {
    private Integer uId;
    private String uName;
    private String uPassword;
    private Timestamp uCreatedDateTime;
    private String uCookie;

    public User() {
    }

    public User(Integer uId, String uName, String uPassword, Timestamp uCreatedDateTime, String uCookie) {
        this.uId = uId;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uCreatedDateTime = uCreatedDateTime;
        this.uCookie = uCookie;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Timestamp getuCreatedDateTime() {
        return uCreatedDateTime;
    }

    public void setuCreatedDateTime(Timestamp uCreatedDateTime) {
        this.uCreatedDateTime = uCreatedDateTime;
    }

    public String getuCookie() {
        return uCookie;
    }

    public void setuCookie(String uCookie) {
        this.uCookie = uCookie;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uCreatedDateTime=" + uCreatedDateTime +
                ", uCookie='" + uCookie + '\'' +
                '}';

    }

}
