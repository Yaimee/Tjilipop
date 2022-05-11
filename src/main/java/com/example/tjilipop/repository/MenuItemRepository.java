package com.example.tjilipop.repository;

import com.example.tjilipop.model.MenuItem;
import com.example.tjilipop.utility.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MenuItemRepository implements CRUDInterface<MenuItem> {
    @Override
    public boolean insert(MenuItem MenuItem) {
        try {
            Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO menu_items  VALUES (" + MenuItem.getName() + ",'" + MenuItem.getPrice() + "'," + MenuItem.getProcent() + ",'" + MenuItem.getOrigin() + "','" + MenuItem.getDescription() + "')");
            stmt.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something wrong inserting event into database");
        }
        return true;
    }

    @Override
    public MenuItem getSingleEntity(int id) {
        return null;
    }

    @Override
    public List<MenuItem> getList() {
        return null;
    }

    @Override
    public boolean update(MenuItem MenuItem) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
