package com.capgemini.Model.Booking;

import com.capgemini.Model.Guests.Guest;
import com.capgemini.Model.Kamers.Room;

import java.time.LocalDate;

/**
 * Created by DIVELDHU on 8-5-2017.
 */
public class Booking {
   
    public Booking(LocalDate start, LocalDate end, Guest guest, Room room, int bookingNumber) {
        this.start = start;
        this.end = end;
        this.guest = guest;
        this.room = room;
        this.bookingNumber = bookingNumber;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEind() {
        return end;
    }

    public void setEind(LocalDate end) {
        this.end = end;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    private LocalDate start;
    private LocalDate end;
    private Guest guest;
    private Room room;
    private int bookingNumber;
    
       
    
}
