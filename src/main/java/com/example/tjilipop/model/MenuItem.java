package com.example.tjilipop.model;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;

public class MenuItem {
    private int id;
    private String name;
    private int price;
    private int procent;
    private String origin;
    private String description;

    MenuItem() {

    }

    public MenuItem(ResultSet rs) {
        try {
            this.id = rs.getInt(1);
            this.name = rs.getString(2);
            this.price = rs.getInt(3);
            this.procent = rs.getInt(4);
            this.origin = rs.getString(5);
            this.description = rs.getString(6);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong and the MenuItem was not created.");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getProcent() {
        return procent;
    }

    public void setProcent(int procent) {
        this.procent = procent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", date=" +
                ", time=" +
                ", info='" + description + '\'' +
                '}';
    }
}
