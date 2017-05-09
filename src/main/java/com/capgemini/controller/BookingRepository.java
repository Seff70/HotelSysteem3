package com.capgemini.controller;

import com.capgemini.Model.Booking.Booking;
import com.capgemini.Model.Guests.Guest;
import com.capgemini.Model.Kamers.Etype;
import com.capgemini.Model.Kamers.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingRepository {

    @Autowired
    DatabaseService databaseService;

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    RoomRepository roomRepository;


    public ArrayList<Booking> getAllBookings() throws SQLException {
        ArrayList<Booking> bookingList = new ArrayList<>();
        try (Connection connection = databaseService.getConnection("hotel2")) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Booking")) {
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        bookingList.add(mapBooking(rs));
                    }
                }
            }
        }
        return bookingList;
    }

    public Booking getBooking(int id) throws SQLException {
        try (Connection connection = databaseService.getConnection("hotel2")) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Booking WHERE BookingID = ?")) {
                statement.setInt(1, id);
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        return mapBooking(rs);
                    }
                }
            }
        }
        return null;
    }

    private Booking mapBooking(ResultSet rs) throws SQLException {
        LocalDate start = rs.getDate("startDate").toLocalDate();
        LocalDate end = rs.getDate("endDate").toLocalDate();
        int bookingID = rs.getInt("BookingID");
        int roomID = rs.getInt("RoomID");
        int guestID = rs.getInt("GuestID");

        Guest guest = guestRepository.getGuest(guestID);
        Room room = roomRepository.getRoom(roomID);
        //room.setRoomNumber(roomID);
        //room.setRoomType(Etype.Luxe);
        Booking booking = new Booking(start, end, guest, room, bookingID);
        return booking;
    }
}