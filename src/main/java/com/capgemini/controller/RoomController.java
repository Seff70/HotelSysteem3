package com.capgemini.controller;

import com.capgemini.Model.Kamers.Etype;
import com.capgemini.Model.Kamers.Room;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import java.util.Random;

/**
 * Created by LMANNA on 3-5-2017.
 */

@RestController
public class RoomController {

    @RequestMapping(value = "api/kamergegevens", method = RequestMethod.GET)
    public ArrayList<Room> get() {
        ArrayList<Room> roomList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Room room = new Room();
            room.setRoomNumber(i);
            room.setGuestLastName("Pietje" + i);
            if (i < 5) {
                room.setRoomType(Etype.Standaard);
            } else {
                room.setRoomType(Etype.Luxe);
            }
            roomList.add(room);
        }
        return roomList;
    }
}
