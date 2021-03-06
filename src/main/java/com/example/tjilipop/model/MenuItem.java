package com.example.tjilipop.model;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
//Rasmus kode
public class MenuItem {
    private int id;
    private String name;
    private int price;
    private double procent;
    private String origin;
    private String description;
    private String imageURL;

    public MenuItem() {

    }

    public MenuItem(ResultSet rs) {

        try {
            this.id = rs.getInt(1);
            this.name = rs.getString(2);
            this.price = rs.getInt(3);
            this.procent = rs.getDouble(4);
            this.origin = rs.getString(5);
            this.description = rs.getString(6);
            this.imageURL = rs.getString(7);
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

    public void setName(String name) {
        this.name = name;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", procent=" + procent +
                ", origin='" + origin + '\'' +
                ", description='" + description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
//Rasmus kode