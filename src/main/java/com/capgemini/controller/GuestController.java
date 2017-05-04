package com.capgemini.controller;
import com.capgemini.Model.Guests.Guest;
import org.springframework.web.bind.annotation.*;

@RestController
// het is een referentie naar een stukje code in dit geval de restcontroller

public class GuestController {

    @RequestMapping(value = "/guest", method= RequestMethod.GET )
    public Guest getGuest(@RequestParam String name,@RequestParam int age){
        // je krijgt geen data binnen maar kunt het wel uitlezen
        // Spring maakt er automatisch js van
        Guest g = new Guest();
        g.setName(name);

        return g;
    }
    @RequestMapping(value= "/guest", method= RequestMethod.POST)
    public String setGuest(@RequestBody Guest g){
        return g.getName();

    }

}
