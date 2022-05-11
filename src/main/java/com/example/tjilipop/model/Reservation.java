package com.example.tjilipop.model;

import java.sql.ResultSet;
import java.sql.Time;
import java.util.Date;

public class Reservation {
    /* Her skal alle navnene på String variablerne være
    PRÆCIS det samme som "name" attribut fra vores HTML dokument (reservation)
    HUSK også at lave gettere og settere (ved at højre klikke og trykke på generate)*/
    private int id;
    private String fullName;
    private Date date;
    private Time time;
    private String phone;
    private String email;
    private int numberOfGuests;
    private String message;

    public Reservation(ResultSet rs) {
        try {
            this.id = rs.getInt(1);
            this.fullName = rs.getString(2);
            this.date = rs.getDate(3);
            this.time = rs.getTime(4);
            this.phone = rs.getString(5);
            this.email = rs.getString(6);
            this.numberOfGuests = rs.getInt(7);
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullMame) {
        this.fullName = fullName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
