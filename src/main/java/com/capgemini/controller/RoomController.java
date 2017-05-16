package com.capgemini.controller;

import com.capgemini.Model.Kamers.Room;
import com.capgemini.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController
public class RoomController {

    @Autowired
    RoomRepository roomRepository;


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
}


