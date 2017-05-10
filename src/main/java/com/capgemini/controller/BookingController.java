package com.capgemini.controller;

import com.capgemini.Model.Booking.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by LMANNA on 3-5-2017.
 */

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @RequestMapping(value = "api/bookings", method = RequestMethod.GET)
    public ArrayList <Booking> get() throws SQLException {
        return bookingRepository.getAllBookings();
    }

}