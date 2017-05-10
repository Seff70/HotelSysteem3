package com.capgemini.controller;

import com.capgemini.Model.Kamers.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController
public class RoomController {

//    @Autowired
//    RoomRepository roomRepository;
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

    @RequestMapping(value= "/api/rooms/addroom", method=RequestMethod.POST)
    public Room addRoom (@RequestBody Room room) throws SQLException {
        return roomRepository.save(room);
    }

}


