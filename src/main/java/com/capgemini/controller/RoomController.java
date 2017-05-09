package com.capgemini.controller;

import com.capgemini.Model.Kamers.Etype;
import com.capgemini.Model.Kamers.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by LMANNA on 3-5-2017.
 */

@RestController
public class RoomController {

    @Autowired
    DatabaseService databaseService;

    @RequestMapping(value = "api/kamergegevens", method = RequestMethod.GET)
    public ArrayList<Room> get() throws SQLException {
        Connection connection = databaseService.getConnection("hotel2");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Room");
        ResultSet rs = statement.executeQuery();

        ArrayList<Room> roomList = new ArrayList<>();

        while (rs.next()) {
            int roomNumber = rs.getInt("roomNumber");
            String typeOfRoom = rs.getString("type");
            Etype roomType = Etype.valueOf(typeOfRoom);
            Room room = new Room();
            room.setRoomNumber(roomNumber);
            room.setRoomType(roomType);
            roomList.add(room);
        }

        return roomList;
    }

}
