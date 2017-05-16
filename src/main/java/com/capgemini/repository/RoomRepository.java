package com.capgemini.repository;

import com.capgemini.Model.Kamers.Room;
import com.capgemini.Model.Kamers.RoomType;
import org.apache.tomcat.jni.Local;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface RoomRepository extends CrudRepository<Room, Integer> {
    Room findByRoomNumber(int roomNumber);

}

