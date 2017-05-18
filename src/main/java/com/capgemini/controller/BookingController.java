package com.capgemini.controller;

import com.capgemini.Model.Booking.Booking;
import com.capgemini.Model.Booking.BookingDTO;
import com.capgemini.Model.Guests.Guest;
import com.capgemini.Model.Kamers.Room;
import com.capgemini.repository.BookingRepository;
import com.capgemini.repository.GuestRepository;
import com.capgemini.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;


@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(value = "api/bookings", method = RequestMethod.GET)
    public Iterable<BookingDTO> getAll() throws SQLException {
        Iterator<Booking> bookings = bookingRepository.findAll().iterator();
        ArrayList<BookingDTO> result = new ArrayList<>();
        while(bookings.hasNext()){
            BookingDTO bookingDTO = new BookingDTO(bookings.next());
            result.add(bookingDTO);
        }
        return result;

    }

    @RequestMapping(value = "api/booking/{bookingID}", method = RequestMethod.GET)
    public BookingDTO get(@PathVariable int bookingID) throws SQLException {

        return new BookingDTO(bookingRepository.findOne(bookingID));
    }

     @RequestMapping(value = "api/addbooking", method = RequestMethod.POST)
    public BookingDTO addBooking(@RequestBody BookingDTO b) throws SQLException {
        System.out.println("nu bij bookingController");
        Booking booking = new Booking(b);
        return new BookingDTO(bookingRepository.save(booking));
    }


}