package com.capgemini.controller;

import com.capgemini.Model.Booking.Booking;
import com.capgemini.Model.Guests.Guest;
import com.capgemini.Model.Kamers.Room;
import com.capgemini.repository.BookingRepository;
import com.capgemini.repository.GuestRepository;
import com.capgemini.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;



@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(value = "api/bookings", method = RequestMethod.GET)
    public Iterable<Booking> getAll() throws SQLException {
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "api/booking/{bookingID}", method = RequestMethod.GET)
    public Booking get(@PathVariable int bookingID) throws SQLException {
        return bookingRepository.findOne(bookingID);
    }

    @RequestMapping(value = "api/make4bookings", method = RequestMethod.GET)
    public void make4Bookings() throws SQLException {
        System.out.println("new random booking");
        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now().plusDays(7);
        for (int i = 13; i < 17; i++) {
            System.out.println("new random booking " + i);
            Room r = roomRepository.findOne(i+37);
            Guest g = guestRepository.findOne(i);
            Booking b = new Booking(start.plusDays(i), end.plusDays(i),g ,r );
            bookingRepository.save(b);
        }
    }

    @RequestMapping(value = "api/addbooking", method = RequestMethod.POST)
    public Booking addBooking(@RequestBody Booking b) throws SQLException {
        System.out.println("nu bij bookingController");
        return bookingRepository.save(b);
    }
}