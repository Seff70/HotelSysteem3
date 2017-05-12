package com.capgemini.controller;

import com.capgemini.Model.Booking.Booking;
import com.capgemini.Model.Guests.Guest;
import com.capgemini.Model.Kamers.Room;
import com.capgemini.repository.BookingRepository;
import com.capgemini.repository.GuestRepository;
import com.capgemini.repository.RoomRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(value = "api/bookings", method = RequestMethod.GET)
    public Iterable<Booking> get() throws SQLException {
        return bookingRepository.findAll();
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
}