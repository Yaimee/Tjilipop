package com.example.tjilipop.repository;
import com.example.tjilipop.model.Event;
import com.example.tjilipop.model.Reservation;
import com.example.tjilipop.utility.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReservationsRepository implements CRUDInterface<Reservation> {

    @Override
    public boolean insert(Reservation reservation) {
        try {
            Connection con = Database.getConnection();
            /*Husk at du skal først sige hvilke columns du gerne vil indsætte i og derefter de værdier du gerne vil indsætte*/
            PreparedStatement stmt = con.prepareStatement("INSERT INTO reservation_test.new_table (full_name, telephone, email, numberOfGuests, message) VALUES ('" + reservation.getFullname() + "','" + reservation.getTelephone() + "','" + reservation.getEmail() + "','" + reservation.getNum_of_people() + "','" + reservation.getMessage() + "')");
            stmt.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something wrong inserting reservation into database");
        }
        return true;
    }

    @Override
    public Reservation getSingleEntity(int id) {return null;}

    @Override
    public List<Reservation> getList() {
        return null;
    }

    @Override
    public boolean update(Reservation entity) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
