package com.example.tjilipop.model;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
//Rasmus kode
public class Event {
    private int id;
    private String name;
    private Date date;
    private String time;
    private String info;
    private String imageURL;

    //Det er vigtigt at have en tom contructor, når der skal kreeres et objekt med @modelattribute.
    public Event() {

    }

    public Event(ResultSet rs) {
        try {
            this.id = rs.getInt(1);
            this.name = rs.getString(2);
            this.date = rs.getDate(3);
            this.time = rs.getString(4);
            this.info = rs.getString(5);
            this.imageURL = rs.getString(6);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong and the event was not created");
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", info='" + info + '\'' +
                '}';
    }
}
//Rasmus kode