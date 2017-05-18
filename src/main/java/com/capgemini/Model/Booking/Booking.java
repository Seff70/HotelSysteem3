package com.capgemini.Model.Booking;

import com.capgemini.Model.Guests.Guest;
import com.capgemini.Model.Kamers.Room;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * Created by DIVELDHU on 8-5-2017.
 */


@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingNumber;
    private Date start;
    private Date end;
    @ManyToOne
    private Guest guest;
    @ManyToOne
    private Room room;

    public Booking(Date start, Date end, Guest guest, Room room) {
        this.start = start;
        this.end = end;
        this.guest = guest;
        this.room = room;
    }

    public Booking(BookingDTO b) {
        this.start = b.getStart();
        this.end = b.getEnd();
        this.guest = b.getGuest();
        this.room = b.getRoom();
    }

    public BookingDTO toBookingDTO() {
        return new BookingDTO(this);
    }

    public Booking() {
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
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

//    public void setBookingNumber(int bookingNumber) {
//        this.bookingNumber = bookingNumber;
//    }


}