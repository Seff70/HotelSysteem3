package com.capgemini.controller;
import com.capgemini.Model.Guests.Guest;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
// het is een referentie naar een stukje code in dit geval de restcontroller

public class GuestController extends AbstractDatabaseController {

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
    public ArrayList<Guest> getGuestList() throws SQLException {
        System.out.println("banaan");

        Connection connection = getConnection("hotel5");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Guest");
        ResultSet rs = statement.executeQuery();
        ArrayList<Guest> guestList = new ArrayList<>();
        while(rs.next()) {
            String naam = rs.getString("Name");
            Guest guest = new Guest();
            guest.setName(naam);
            // TODO: alle velden vullen
            guestList.add(guest);
        }

        guestList.add(new Guest("Robbert vd Pas", "Dasselaarweg 10", "3896LT", "Zeewolde", "Nederland", "06-12345234", "Opperdocent"));
        guestList.add(new Guest("Kim Lammers","Singel 14","1023AB","Amsterdam","Nederland","06-12345678","hockey"));
        guestList.add(new Guest("Ruud van Nistelrooij","Have 3", "7800AA","Eindhoven","Nederland","06-45678912","voetbal"));
        guestList.add(new Guest("Yuri van Gelder","Strand 145a","2104SW", "Oranjestad","Curaçao","0900-45678","ringen"));

        return guestList;
    }

}