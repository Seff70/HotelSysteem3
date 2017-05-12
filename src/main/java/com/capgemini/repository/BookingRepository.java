package com.capgemini.repository;

import com.capgemini.Model.Booking.Booking;
import com.capgemini.Model.Kamers.Room;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository <Booking, Integer> {

    }

