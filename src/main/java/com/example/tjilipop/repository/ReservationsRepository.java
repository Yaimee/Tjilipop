package com.example.tjilipop.repository;
import com.example.tjilipop.model.Reservation;
import com.example.tjilipop.utility.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationsRepository implements CRUDInterface<Reservation> {

    @Override
    public boolean insert(Reservation reservation) {
        try {
            Connection con = DatabaseManager.getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO reservations VALUES ('" + reservation.getFullname() + "','" + reservation.getTelephone() + "'," + reservation.getEmail() + ",'" + reservation.getNum_of_people() + "',)");
            stmt.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong inserting reservation into database");
        }
        return true;
    }

    @Override
    public Reservation getSingleEntity(int id) {
        Reservation reservation = null;

        try {
            Connection con = DatabaseManager.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM reservations WHERE id = "+ id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            reservation = new Reservation(rs);
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong in fetching an event from database");
        }

        return reservation;
    }

    @Override
    public List<Reservation> getList(String dbTable) {
        List<Reservation> reservationList = new ArrayList<>();

        try {
            Connection con = DatabaseManager.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM reservations");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Reservation reservation = new Reservation(rs);
                reservationList.add(reservation);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong with the list");
        }

        return reservationList;
    }

    @Override
    public boolean update(Reservation reservation) {
        try {
            Connection con = DatabaseManager.getConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE reservations SET full_name = '" + reservation.getFullname() + "', date = '" + reservation.getDate() + "', time = '" + reservation.getTime() + "', email = '" + reservation.getEmail() + "', phone = " + reservation.getTelephone() + ", number_of_guests = " + reservation.getNum_of_people() + ", info = '" + reservation.getMessage() + "' WHERE id = "+ reservation.getId());
            stmt.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong fetching a reservation from database");
        }

        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection con = DatabaseManager.getConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM reservations WHERE id = " + id);
            stmt.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong, deleting a reservation from database");
        }

        return true;
    }
}
