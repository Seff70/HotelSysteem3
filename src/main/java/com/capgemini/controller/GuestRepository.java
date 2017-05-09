package com.capgemini.controller;

import com.capgemini.Model.Guests.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerard on 9-5-17.
 */
@Service
public class GuestRepository {

    @Autowired
    DatabaseService databaseService;

    public List<Guest> getAllGuests() throws SQLException {
        ArrayList<Guest> guestList = new ArrayList<>();
        try (Connection connection = databaseService.getConnection("hotel2")) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Guest")) {
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        guestList.add(mapGuest(rs));
                    }
                }
            }
        }
        return guestList;
    }

    public Guest getGuest(int id) throws SQLException {
        try (Connection connection = databaseService.getConnection("hotel2")) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Guest WHERE GuestID = ?")) {
                statement.setInt(1, id);
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        return mapGuest(rs);
                    }
                }
            }
        }
        return null;
    }

    private Guest mapGuest(ResultSet rs) throws SQLException {
        String naam = rs.getString("Name");
        Guest guest = new Guest(rs.getString("name"), rs.getString("address"), rs.getString("zipcode"), rs.getString("city"), rs.getString("country"), rs.getString("phonenumber"),rs.getString("special") );
        return guest;
    }
}
