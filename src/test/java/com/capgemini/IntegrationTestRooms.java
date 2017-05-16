//package com.capgemini;
//
//import com.capgemini.Model.Kamers.Room;
//import com.capgemini.Model.Kamers.RoomType;
//import com.capgemini.controller.RoomController;
//import org.assertj.core.util.Lists;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
// * Basis integratietest voor Spring boot applicatie
// */
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class IntegrationTestRooms {
//
//    @Autowired
//    private RoomController roomController;
//
//    @Test
//    public void testRoomRetrieval() throws Exception {
//        final List<Room> rooms = Lists.newArrayList(roomController.getRoomList());
//        assertNotNull(rooms);
//        assertEquals(10, rooms.size());
//    }
//
//    @Test
//    public void testAddRoom() throws Exception {
//        final Room room = new Room(100, RoomType.Standaard, true);
//        Room result = roomController.saveRoom(room);
//
//        assertNotNull(result);
//        assertTrue(result.getRoomID() > 0);
//
//        System.out.println(result.getRoomID());
//
//        final Room lookup = roomController.getRoom(room.getRoomNumber());
//        assertNotNull(lookup);
//        assertEquals(result.getRoomID(), lookup.getRoomID());
//
//        roomController.deleteRoom(room.getRoomID());
//
//        assertNull(roomController.getRoom(result.getRoomNumber()));
//    }
//}
