package com.example.tjilipop.utility;

import com.example.tjilipop.model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginManager {
    public void updateLogin(Login login) {
        try {
            Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE login SET username = '" + login.getUsername() + "', password = '" + login.getPassword() + "' WHERE username = '" + login.getUsername() + "'");
            stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong, updating password in database");
        }
    }

    public Login getLogin() {
        Login login = null;

        try {
            Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM `menu_test`.`user`");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            login = new Login(rs);
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong in fetching an event from database");
        }
        System.out.println(login.toString());
        return login;
    }
}
