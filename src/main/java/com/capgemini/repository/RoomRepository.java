package com.capgemini.repository;

import com.capgemini.Model.Kamers.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer> {
    Room findByRoomNumber(int roomNumber);
}

