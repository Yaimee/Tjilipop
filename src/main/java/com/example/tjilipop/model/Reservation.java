package com.example.tjilipop.model;

import java.sql.ResultSet;

public class Reservation {

    /* Her skal alle navnene på String variablerne være
        PRÆCIS det samme som "name" attribut fra vores HTML dokument (reservation)
        HUSK også at lave gettere og settere (ved at højre klikke og trykke på generate)*/
    private int id;
    private String fullname;
    private long telephone;
    private String email;
    private int num_of_people;
    private String message;

    /*Det er vigtigt at når man bruger @ModelAttribute at man har en tom constructor,
    så @ModelAttribute kan bruge den eller noget lign.*/
    Reservation() {

    }

    Reservation(String fullname, int telephone, String email, int numberOfGuests, String message) {
        this.fullname = fullname;
        this.telephone = telephone;
        this.email = email;
        this.num_of_people = numberOfGuests;
        this.message = message;
    }

    public Reservation(ResultSet rs) {
        try {
            this.id = rs.getInt(1);
            this.fullname = rs.getString(2);
            this.telephone = rs.getInt(3);
            this.email = rs.getString(4);
            this.num_of_people = rs.getInt(5);
            this.message = rs.getString(6);
        } catch (Exception e) {
            e.printStackTrace();
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

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
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
