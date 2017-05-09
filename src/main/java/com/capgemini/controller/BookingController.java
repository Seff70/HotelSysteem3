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
    BookingRepository bookingRepository;


    @RequestMapping(value = "api/bookings", method = RequestMethod.GET)
    public ArrayList <Booking> getBookings() throws SQLException {

        return bookingRepository.getAllBookings();



    }

}