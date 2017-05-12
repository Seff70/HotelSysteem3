package com.capgemini.Model.Booking;

import com.capgemini.Model.Guests.Guest;
import com.capgemini.Model.Kamers.Room;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by DIVELDHU on 8-5-2017.
 */


@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingNumber;
    private LocalDate start;
    private LocalDate end;
    @ManyToOne
    private Guest guest;
    @ManyToOne
    private Room room;

    public Booking(){
    }
    
    public Booking(LocalDate start, LocalDate end, Guest guest, Room room) {
        this.start = start;
        this.end = end;
        this.guest = guest;
        this.room = room;
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

       
    
}
