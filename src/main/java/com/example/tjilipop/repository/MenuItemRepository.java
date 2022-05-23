package com.example.tjilipop.repository;

import com.example.tjilipop.model.Event;
import com.example.tjilipop.model.MenuItem;
import com.example.tjilipop.utility.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuItemRepository implements CRUDInterface<MenuItem> {
    private CRUDInterface<Event> eventsRepository = new EventsRepository();
    @Override
    public boolean insert(MenuItem menuItem) {
        try {
            Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO øl VALUES ('" + menuItem.getName() + "'," + menuItem.getPrice() + "," + menuItem.getProcent() + ",'" + menuItem.getOrigin() + "','" + menuItem.getDescription() + "')");
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
            Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM øl WHERE id = "+ id);
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
            Connection con = Database.getConnection();
            String strQuery = "SELECT * FROM tableName";
            /*ved at bruge replace kan man erstatte noget i en string med noget andet*/
            String query = strQuery.replace("tableName",dbTable);
            PreparedStatement stmt = con.prepareStatement(query);
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
            Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE øl SET id = "+ menuItem.getId() + ", name = '" + menuItem.getName() + "', price = '" + menuItem.getPrice() + "', procent = '" + menuItem.getProcent() + "', origin = '" + menuItem.getOrigin() + "', description = '" + menuItem.getDescription() + "' WHERE id = " + menuItem.getId());
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
            Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM øl WHERE id = " + id);
            stmt.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong, deleting an item from database");
        }

        return true;
    }
}
