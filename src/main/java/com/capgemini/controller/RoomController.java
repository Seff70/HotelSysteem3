package com.capgemini.controller;

import com.capgemini.Model.Guests.Guest;
import com.capgemini.Model.Kamers.Etype;
import com.capgemini.Model.Kamers.Room;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Random;


/**
 * Created by LMANNA on 3-5-2017.
 */

@RestController
public class RoomController extends AbstractDatabaseController {

    @RequestMapping(value = "api/kamergegevens", method = RequestMethod.GET)
    public ArrayList<Room> get()throws SQLException {
        ArrayList<Room> roomList = new ArrayList<>();

        Connection connection = getConnection("hotel2");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Room");
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            int roomNumber = rs.getInt("roomnumber");
            String roomType = rs.getString("type");
            Etype roomTypeEnum = Etype.valueOf(roomType);
            Room room = new Room();
            room.setRoomNumber(roomNumber);
            room.setRoomType(roomTypeEnum);
            // TODO: alle velden vullen
            roomList.add(room);
        }
        for (int i = 0; i < 10; i++) {
            Room room = new Room();
            room.setRoomNumber(i);
            if (i < 5) {
                room.setRoomType(Etype.Standard);
            } else {
                room.setRoomType(Etype.Luxe);
            }
            roomList.add(room);
        }
        return roomList;
    }
}
