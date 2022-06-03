package com.example.tjilipop.model;

import java.sql.ResultSet;
import java.sql.Time;
import java.util.Date;
public class Reservation {
    /* Her skal alle navnene på String variablerne være
    PRÆCIS det samme som "name" attribut fra vores HTML dokument (reservation)
    HUSK også at lave gettere og settere (ved at højre klikke og trykke på generate)*/
    private int id;
    private String fullname;
    private Date date;
    private Time time;
    private String telephone;
    private String email;
    private int num_of_people;
    private String message;

    public Reservation() {

    }

    public Reservation(String fullname, String telephone, String email, int numberOfGuests, String message) {
        this.fullname = fullname;
        this.telephone = telephone;
        this.email = email;
        this.num_of_people = numberOfGuests;
        this.message = message;
    }

    public Reservation(ResultSet rs) {
        try {
            this.fullname = rs.getString(2);
            this.date = rs.getDate(3);
            this.time = rs.getTime(4);
            this.telephone = rs.getString(5);
            this.email = rs.getString(6);
            this.num_of_people = rs.getInt(7);
            this.message = rs.getString(8);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong, instantiating a reservation object");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getTelephone() {
        return telephone;
    }

    public void setPhone(String phone) {
        this.telephone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNum_of_people() {
        return num_of_people;
    }

    public void setNum_of_people(int num_of_people) {
        this.num_of_people = num_of_people;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

