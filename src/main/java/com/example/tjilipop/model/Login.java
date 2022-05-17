package com.example.tjilipop.model;

import java.sql.ResultSet;

public class Login {
    private String username;
    private String password;

    public Login() {

    }
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login(ResultSet rs) {
        try {
            this.username = rs.getString(1);
            this.password = rs.getString(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
