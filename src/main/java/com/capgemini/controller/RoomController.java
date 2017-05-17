package com.capgemini.controller;

import com.capgemini.Model.Booking.Booking;
import com.capgemini.Model.Kamers.Room;
import com.capgemini.Model.Kamers.RoomType;
import com.capgemini.repository.BookingRepository;
import com.capgemini.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.awt.print.Book;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;


@RestController
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    BookingRepository bookingRepository;


    @RequestMapping(value= "/api/rooms", method=RequestMethod.GET)
    public Iterable<Room> getRoomList() throws SQLException {
        return roomRepository.findAll();
    }

    @RequestMapping(value= "/api/rooms/{roomNumber}", method=RequestMethod.GET)
    public Room getRoom(@PathVariable int roomNumber) throws SQLException {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    @RequestMapping(value= "/api/rooms", method=RequestMethod.POST)
    public Room saveRoom (@RequestBody Room room) throws SQLException {
        return roomRepository.save(room);
    }

    @RequestMapping(value= "/api/rooms/{roomNumber}", method=RequestMethod.DELETE)
    public void deleteRoom (@PathVariable int roomNumber) throws SQLException {
         roomRepository.delete(roomNumber);

    }

    @RequestMapping(value = "/api/rooms/{startDate}/{endDate}/{roomType}", method = RequestMethod.GET)
    public Iterable<Room> getSelectedRooms (@PathVariable String startDate,@PathVariable String endDate,@PathVariable String roomType) throws SQLException {
        System.out.println("in getSelectedRooms");
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("ddMMyyyy"));
        LocalDate eind = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("ddMMyyyy"));
        RoomType type = null;

        if(roomType.equalsIgnoreCase(RoomType.Luxe.toString()))  {
            type = RoomType.Luxe;
        } else {
            if(roomType.equalsIgnoreCase(RoomType.Standaard.toString())) {
                type = RoomType.Standaard;
            }
        }

        ArrayList<Room> selectedRooms = new ArrayList <Room>();

        for (Room room : roomRepository.findAll()) {
            if (room.isAvailable()) {
                if (type==null) {
                    System.out.println("room "+ room.getRoomNumber() + " is available, misschien nog wel booking op");
                    selectedRooms.add(room);
                } else {
                    if (type == room.getRoomType()) {
                        System.out.println("room "+ room.getRoomNumber() + " is available, misschien nog wel booking op");
                        selectedRooms.add(room);
                    }
                }
            }
        }

        ArrayList<Room> roomsToBeRemovedFromSelectedRooms = new ArrayList <>();

        for (Booking booking : bookingRepository.findAll()) {

            if (booking.getEnd() == null) { booking.setEnd(LocalDate.MAX);}

            for (Room room : selectedRooms) {
                if (booking.getRoom().equals(room)) {
                    if (!(booking.getEnd().isBefore(start.plusDays(1)) || eind.isBefore(booking.getStart().plusDays(1)) ) ) {
                        System.out.println("room " + room.getRoomNumber() + " is verwijderd uit de lijst, omdat er een boeking op was");
//                        selectedRooms.remove(room);
                        roomsToBeRemovedFromSelectedRooms.add(room);
                    }
                }
            }

        }
        selectedRooms.removeAll(roomsToBeRemovedFromSelectedRooms);
        return selectedRooms;
    }
}


