package com.capgemini.controller;

import com.capgemini.Model.Kamers.Room;
import com.capgemini.Model.Kamers.RoomType;
import com.capgemini.repository.RoomRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.mockito.Mockito.*;

/**
 * Created by diveldhu on 15-5-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class RoomControllerTest {

    @InjectMocks
    private RoomController roomControllerMock;

    @Mock
    private RoomRepository roomRepository;

//    @Test
//    public void test() throws Exception {
//        when(roomRepository.findAll()).thenThrow(SQLException.class);
//
//        roomControllerMock.getRoomList();
//
//        verify(roomRepository, times(1)).findAll();
//    }


    @Test
    public void getRoomListTest() throws Exception {
        roomControllerMock.getRoomList();
        verify(roomRepository, times(1)).findAll();
    }

    @Test(expected = SQLException.class)
    public void getRoomListTestException() throws Exception{
        when(roomRepository.findAll()).thenThrow(SQLException.class);
        roomRepository.findAll();
    }

    @Test
    public void getRoomTest() throws Exception {
        roomControllerMock.getRoom(456789);
        verify(roomRepository, times(1)).findByRoomNumber(456789);
    }
    @Test(expected = SQLException.class)
    public void getRoomSQLExcep() throws Exception {
        when(roomRepository.findByRoomNumber(123)).thenThrow(SQLException.class);
        roomRepository.findByRoomNumber(123);
    }

    @Test
    public void saveRoomTest() throws Exception {
        Room r = new Room(2, RoomType.Luxe, false);
        roomControllerMock.saveRoom(r);
        verify(roomRepository, times(1)).save(r);
    }

    @Test
    public void deleteRoomTest() throws Exception {
        roomControllerMock.deleteRoom(2);
        verify(roomRepository, times(1)).delete(2);
    }

}