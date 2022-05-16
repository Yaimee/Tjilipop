package com.example.tjilipop.utility;

import com.example.tjilipop.model.Event;
import com.example.tjilipop.model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordManager {
    public void updateLogin(Login login) {

    }

    public Login getLogin() {
        Login login = null;

        try {
            Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM login");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            login = new Login(rs);
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong in fetching an event from database");
        }

        return login;
    }
}
