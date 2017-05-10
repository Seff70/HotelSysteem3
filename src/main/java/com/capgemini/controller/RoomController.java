package com.capgemini.controller;

import com.capgemini.Model.Kamers.Etype;
import com.capgemini.Model.Kamers.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class RoomController {

//    @Autowired
//    RoomRepository roomRepository;
    @Autowired
    RoomInterfaceRepository roomInterfaceRepository;


    @RequestMapping(value= "/api/rooms", method=RequestMethod.GET)
    public Iterable<Room> getRoomList() throws SQLException {
        return roomInterfaceRepository.findAll();
    }

    @RequestMapping(value= "/api/rooms/{roomNumber}", method=RequestMethod.GET)
    public Room getRoom(@PathVariable int roomNumber) throws SQLException {
        return roomInterfaceRepository.findByRoomNumber(roomNumber);
    }

    @RequestMapping(value= "/api/rooms/addroom", method=RequestMethod.POST)
    public Room addRoom (@RequestBody Room room) throws SQLException {
        return roomInterfaceRepository.save(room);
    }

}


