package com.example.tjilipop.repository;

import com.example.tjilipop.model.Event;
import com.example.tjilipop.utility.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//Rasmus kode
public class EventsRepository implements CRUDInterface<Event> {

    @Override
    public boolean insert(Event event) {
        try {
            Connection con = DatabaseManager.getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO `tjili-pop`.events (name,date,time,info,image_URL) VALUES ('" + event.getName() + "','" + event.getDate() + "','" + event.getTime() + "','" + event.getInfo() + "','" + event.getImageURL() + "')");
            stmt.execute();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something wrong inserting event into database");
        }
        return true;
    }

    @Override
    public Event getSingleEntity(int id) {
        Event event = null;

        try {
            Connection con = DatabaseManager.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM events WHERE id = "+ id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            event = new Event(rs);
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong in fetching an event from database");
        }

        return event;
    }

    @Override
    public List<Event> getList(String dbTable) {
        List<Event> eventList = new ArrayList<>();

            try {
                /* Tobias kode */
                Connection con = DatabaseManager.getConnection();
                String strQuery = "SELECT * FROM tableName";
                /*ved at bruge replace kan man erstatte noget i en string med noget andet*/
                String query = strQuery.replace("tableName",dbTable);
                PreparedStatement stmt = con.prepareStatement(query);
                /* Tobias kode */
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    Event event = new Event(rs);
                    eventList.add(event);
                }
            } catch(SQLException e) {
                e.printStackTrace();
                System.out.println("Something went wrong with the list");
            }

        return eventList;
    }

    @Override
    public boolean update(Event event) {

        try {
            Connection con = DatabaseManager.getConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE events SET name = '" + event.getName() + "', date = '" + event.getDate() + "', time = '" + event.getTime() + "', info = '" + event.getInfo() + "' WHERE id = "+ event.getId());
            stmt.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong in fetching an event from database");
        }

        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection con = DatabaseManager.getConnection();
            PreparedStatement stmt = con.prepareStatement("DELETE FROM events WHERE id = " + id);
            stmt.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong in fetching an event from database");
        }

        return true;
    }
}
//Rasmus kode