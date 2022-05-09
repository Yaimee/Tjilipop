package com.example.tjilipop.Model;

public class Reservation {
    /* Her skal alle navnene på String variablerne være
    PRÆCIS det samme som "name" attribut fra vores HTML dokument (reservation)
    HUSK også at lave gettere og settere (ved at højre klikke og trykke på generate)*/
    private String fullname;
    private String telephone;
    private String email;
    private String num_of_people;
    private String message;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum_of_people() {
        return num_of_people;
    }

    public void setNum_of_people(String num_of_people) {
        this.num_of_people = num_of_people;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
