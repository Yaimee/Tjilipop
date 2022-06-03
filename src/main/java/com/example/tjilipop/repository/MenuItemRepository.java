package com.example.tjilipop.repository;
import com.example.tjilipop.model.MenuItem;
import com.example.tjilipop.utility.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuItemRepository implements CRUDInterface<MenuItem> {

    @Override
    public boolean insert(MenuItem menuItem) {
        try {
            Connection con = DatabaseManager.getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO beer VALUES ('" + menuItem.getName() + "'," + menuItem.getPrice() + "," + menuItem.getProcent() + ",'" + menuItem.getOrigin() + "','" + menuItem.getDescription() + "','" + menuItem.getImageURL() + "')");
            stmt.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something wrong inserting event into database");
        }
        return true;
    }

    @Override
    public MenuItem getSingleEntity(int id) {
        MenuItem menuItem = null;

        try {
            Connection con = DatabaseManager.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM beer WHERE id = "+ id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            menuItem = new MenuItem(rs);
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong in fetching a MenuItem from database");
        }

        return menuItem;
    }

    @Override
    public List<MenuItem> getList(String dbTable) {
        List<MenuItem> menuList = new ArrayList<>();

        try {
            /* Tobias kode */
            Connection con = DatabaseManager.getConnection();
            String strQuery = "SELECT * FROM tableName";
            /*ved at bruge replace kan man erstatte noget i en string med noget andet*/
            String query = strQuery.replace("tableName",dbTable);
            PreparedStatement stmt = con.prepareStatement(query);
            /* Tobias kode */
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                MenuItem menuItem = new MenuItem(rs);
                menuList.add(menuItem);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong with the list");
        }

        return menuList;
    }

    @Override
    public boolean update(MenuItem menuItem) {

        try {
            System.out.println(menuItem.toString());
            Connection con = DatabaseManager.getConnection();
            String sql = "UPDATE beer SET image_URL = '" + menuItem.getImageURL() + "', name = '" + menuItem.getName() + "', procent = '" + menuItem.getProcent() + "', origin = '" + menuItem.getOrigin() + "', description = '" + menuItem.getDescription() + "' WHERE id = " + menuItem.getId() + ";";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong, updating item in database");
        }

        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection con = DatabaseManager.getConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM beer WHERE id = " + id);
            stmt.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong, deleting an item from database");
        }

        return true;
    }
}
