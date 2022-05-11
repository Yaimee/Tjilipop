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
            PreparedStatement stmt = con.prepareStatement("INSERT INTO menu_items  VALUES ('" + menuItem.getName() + "'," + menuItem.getPrice() + "," + menuItem.getProcent() + ",'" + menuItem.getOrigin() + "','" + menuItem.getDescription() + "')");
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
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM menu_items WHERE id = "+ id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            menuItem = new MenuItem(rs);
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong in fetching an event from database");
        }

        return menuItem;
    }

    @Override
    public List<MenuItem> getList() {
        List<MenuItem> menuList = new ArrayList<>();

        try {
            Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM menu_items");
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
            Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE menu_items SET name = '" + menuItem.getName() + "', date = '" + menuItem.getDate() + "', time = '" + menuItem.getTime() + "', info = '" + event.getInfo() + "' WHERE id = "+ event.getId());
            stmt.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong in fetching an event from database");
        }

        return true;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
