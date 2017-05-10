package com.capgemini.controller;

import com.capgemini.Model.Guests.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Integer> {

}