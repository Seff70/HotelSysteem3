package com.capgemini.controller;

import com.capgemini.Model.Guests.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

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
    //
//
//// }
//    @RequestMapping(value= "/guest", method= RequestMethod.POST)
//    public String setGuest(@RequestBody Guest g){
//        return guestRepository();



    @RequestMapping(value = "/api/guests", method = RequestMethod.GET)
    public Iterable <Guest> getGuestList() throws SQLException {
        return guestRepository.findAll();
    }

    @RequestMapping(value = "/api/guests", method = RequestMethod.POST)
    public Guest addGuestList(@RequestBody Guest guest) throws SQLException {
        return guestRepository.save(guest);
    }

    @RequestMapping(value = "/api/guests/{GuestID}", method = RequestMethod.DELETE)
    public void removeGuest(@PathVariable int GuestID) throws SQLException {
        guestRepository.delete(GuestID);
    }

}