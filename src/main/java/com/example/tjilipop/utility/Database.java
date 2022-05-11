package com.example.tjilipop.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private static String url;
    private static String username;
    private static String password;
    private static Connection con;

    private Database(){}

    public static Connection getConnection(){
        if(con != null){
            return con;
        }

        try {
            //Environment Variables
            url = System.getenv("db.url");
            username = System.getenv("db.username");
            password = System.getenv("db.password");
            con = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
