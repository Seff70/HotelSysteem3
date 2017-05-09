package com.capgemini.controller;

import com.capgemini.Model.Booking.Booking;
import com.capgemini.Model.Guests.Guest;
import com.capgemini.Model.Kamers.Etype;
import com.capgemini.Model.Kamers.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.security.krb5.internal.crypto.EType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Random;

import static java.sql.DriverManager.getConnection;

/**
 * Created by LMANNA on 3-5-2017.
 */

@RestController
public class BookingController {

    @Autowired
    DatabaseService databaseService;
    @Autowired
    GuestRepository guestRepository;

    @RequestMapping(value = "api/bookinggegevens", method = RequestMethod.GET)
    public ArrayList <Booking> get() throws SQLException {
        Connection connection = databaseService.getConnection("hotel2");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Booking");
        ResultSet rs = statement.executeQuery();

        ArrayList <Booking> bookingList = new ArrayList <>();

        while (rs.next()) {
            int roomNumber = rs.getInt("roomNumber");
            LocalDate start = rs.getDate("startDate").toLocalDate();
            LocalDate end = rs.getDate("endDate").toLocalDate();
            int bookingID = rs.getInt("BookingID");
            int roomID = rs.getInt("RoomID");
            int guestID = rs.getInt("GuestID");

            Guest guest = guestRepository.getGuest(guestID);
            Booking b = new Booking(start, end, guest, roomID, bookingID);

            bookingList.add(b);
            }

        return bookingList;
    }

}