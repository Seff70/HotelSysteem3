package com.capgemini.controller;

import com.capgemini.Model.Guests.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
// het is een referentie naar een stukje code in dit geval de restcontroller

public class GuestController {

    @Autowired
    GuestRepository guestRepository;

//    @RequestMapping(value = "/guest", method= RequestMethod.GET )
//    public Guest getGuest(@RequestParam String name,@RequestParam int age){
//        // je krijgt geen data binnen maar kunt het wel uitlezen
//        // Spring maakt er automatisch js van
//        Guest g = new Guest();
//        g.setName(name);
//
//        return g;
//    }
//    @RequestMapping(value= "/guest", method= RequestMethod.POST)
//    public String setGuest(@RequestBody Guest g){
//        return g.getName();
//
//    }

    @RequestMapping(value = "/api/guests", method = RequestMethod.GET)
    public List<Guest> getGuestList() throws SQLException {
        return guestRepository.getAllGuests();
    }

      @RequestMapping(value = "/api/guests", method = RequestMethod.POST)
    public boolean addGuestList(@RequestBody Guest guest) throws SQLException {
        return guestRepository.addGuest(guest);

    }

}