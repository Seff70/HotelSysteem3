package com.capgemini.controller;

import com.capgemini.Model.Kamers.Etype;
import com.capgemini.Model.Kamers.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LMANNA on 3-5-2017.
 */

@RestController
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

//    @RequestMapping(value = "/api/{roomNumber}", method=RequestMethod.GET)
//    public int getRoom (@PathVariable int roomNumber){
//
//    }

//    @RequestMapping(value= "/api/roomList", method=RequestMethod.GET)
//    public List<Room> getRoomList() throws SQLException {
//        return roomRepository.getAllRooms();
//    }

    @RequestMapping(value= "/api/{roomNumber}", method=RequestMethod.POST)
    public Room post(@PathVariable int roomNumber) throws SQLException {
        return roomRepository.getRoom(roomNumber);
    }

}


