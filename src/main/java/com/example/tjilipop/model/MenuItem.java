package com.example.tjilipop.model;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;

public class MenuItem {
    private int id;
    private String name;
    private int price;
    private double procent;
    private Date date;
    private Time time;
    private String origin;
    private String description;

    MenuItem(ResultSet rs) {
        try {
            this.id = rs.getInt(1);
            this.name = rs.getString(2);
            this.price = rs.getInt(3);
            this.date = rs.getDate(4);
            this.time = rs.getTime(5);
            this.origin = rs.getString(6);
            this.description = rs.getString(7);
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

    public void setProcent(double procent) {
        this.procent = procent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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
                ", date=" + date +
                ", time=" + time +
                ", info='" + description + '\'' +
                '}';
    }
}
