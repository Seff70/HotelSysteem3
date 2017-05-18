package com.capgemini.Model.Booking;

import com.capgemini.Model.Guests.Guest;
import com.capgemini.Model.Kamers.Room;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.awt.print.Book;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by JVERDUIJ on 18-5-2017.
 */
public class BookingDTO {
    //dattostring
    //naar booking
    //van booking
    private int bookingNumber;
    private Date start;
    private Date end;
    private Guest guest;
    private Room room;
    private String duration;


    private String guestName;
    private String startString;
    private String endString;
    private int roomNumber;

    public BookingDTO(Booking b) {
        this.bookingNumber = b.getBookingNumber();
        this.start = b.getStart();
        this.end = b.getEnd();
        this.guest = b.getGuest();
        this.room = b.getRoom();
        this.duration = String.valueOf(TimeUnit.DAYS.convert(b.getEnd().getTime() - b.getStart().getTime(), TimeUnit.MILLISECONDS));
        this.guestName = b.getGuest().getName();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.startString = df.format(b.getStart());
        this.endString = df.format(b.getEnd());
        this.roomNumber = b.getRoom().getRoomNumber();

    }

    public BookingDTO(Date start, Date end, Guest guest, Room room) {
        this.bookingNumber = bookingNumber;
        this.start = start;
        this.end = end;
        this.guest = guest;
        this.room = room;
    }

    public Booking toBooking() {
        return new Booking(this);
    }


    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getStartString() {
        return startString;
    }

    public void setStartString(String startString) {
        this.startString = startString;
    }

    public String getEndString() {
        return endString;
    }

    public void setEndString(String endString) {
        this.endString = endString;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }


}
