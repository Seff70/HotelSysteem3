package com.capgemini.controller;
import com.capgemini.Model.Guests.Guest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
// het is een referentie naar een stukje code in dit geval de restcontroller

public class GuestController {

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
    @RequestMapping(value = "/api/guestlist", method= RequestMethod.GET )
    public ArrayList<Guest> getGuestList(){
        System.out.println("banaan");

        ArrayList<Guest> guestList = new ArrayList<>();
        guestList.add(new Guest("Robbert vd Pas", "Dasselaarweg 10", "3896LT", "Zeewolde", "Nederland", "06-12345234", "arsenist"));
        guestList.add(new Guest("Kim Lammers","Singel 14","1023AB","Amsterdam","Nederland","06-12345678","hockey"));
        guestList.add(new Guest("Ruud van Nistelrooij","Have 3", "7800AA","Eindhoven","Nederland","06-45678912","voetbal"));
        guestList.add(new Guest("Yuri van Gelder","Strand 145a","2104SW", "Oranjestad","Curaçao","0900-45678","ringen"));

        return guestList;
    }

}