package com.capgemini.controller;

import com.capgemini.Model.Kamers.Etype;
import com.capgemini.Model.Kamers.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LMANNA on 9-5-2017.
 */
@Service
public class RoomRepository {

    @Autowired
    DatabaseService databaseService;

    public List<Room> getAllRooms() throws SQLException{
        ArrayList<Room> roomList = new ArrayList <>();
        try (Connection connection = databaseService.getConnection("hotel2")){
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Room")){
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        roomList.add(mapRoom(rs));
                    }
                }
            }
        }
        return roomList;
    }

    public Room getRoom(int id) throws SQLException {
        try (Connection connection = databaseService.getConnection("hotel2")){
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Room WHERE roomNumber = ?")){
                statement.setInt(1, id);
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        return mapRoom(rs);
                    }
                }
            }
        }
        return null;
    }


    private Room mapRoom(ResultSet rs) throws SQLException {
        int roomNumber = rs.getInt("roomNumber");
        String typeOfRoom = rs.getString("type");
        Etype roomType = Etype.valueOf(typeOfRoom);
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setRoomType(roomType);

        return room;
    }

    public boolean addRoom (Room room) throws SQLException{
        try (Connection connection = databaseService.getConnection("hotel2")) {
            try (PreparedStatement statement = connection.prepareStatement("insert into Room (roomnumber, type) values (?,?)");) {
                statement.setInt(1,room.getRoomNumber());
//                String roomType = room.getRoomType().toString();
                statement.setString(2,room.getRoomType().toString());
                int result = statement.executeUpdate();
                return result>0;
            }
        }
    }
}
