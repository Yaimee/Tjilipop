package com.example.tjilipop.repository;
import com.example.tjilipop.model.Reservation;
import com.example.tjilipop.utility.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReservationsRepository implements CRUDInterface<Reservation> {

    @Override
    public boolean insert(Reservation reservation) {
        try {
            Connection con = Database.getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO reservations VALUES ('" + reservation.getFullname() + "','" + reservation.getTelephone() + "'," + reservation.getEmail() + ",'" + reservation.getNumberOfGuests() + "',)");
            stmt.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something wrong inserting reservation into database");
        }
        return true;
    }

    @Override
    public Reservation getSingleEntity(int id) {
        return null;
    }

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
