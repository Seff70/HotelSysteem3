package com.capgemini.repository;

import com.capgemini.Model.Guests.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Integer> {
    Iterable<Guest> findByName(String name);
}