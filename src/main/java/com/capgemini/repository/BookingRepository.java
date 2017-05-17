package com.capgemini.repository;

import com.capgemini.Model.Booking.Booking;
import com.capgemini.Model.Kamers.Room;
import com.capgemini.Model.Kamers.RoomType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends CrudRepository <Booking, Integer> {

    //@Query(Select from rooms where )
//    public List<Room> getAvailableRooms(LocalDate startDate, LocalDate endDate);
//
//    public List<Room> getAvailableRoomsWithType(LocalDate startDate, LocalDate endDate, RoomType roomType);


}

