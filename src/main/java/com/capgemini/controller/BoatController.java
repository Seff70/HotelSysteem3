package com.capgemini.controller;

import com.capgemini.Model.Boten.Boat;
import com.capgemini.Model.Boten.Meer;
import com.capgemini.Model.Boten.Rivier;
import com.capgemini.Model.Boten.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class BoatController {

    @Autowired
    BoatRepository boatRepository;

    @Autowired
    TripRepository tripRepository;

    @RequestMapping(value = "/api/boot", method = RequestMethod.GET)
    public Iterable<Boat> boot() throws SQLException {
        return boatRepository.findAll();
    }

    @RequestMapping(value = "/api/addLakeTrip/", method = RequestMethod.POST)
    public Trip newLakeTrip(@RequestBody Boat b) throws SQLException{
        System.out.println("Bootgeg in controller: id= " + b.getBoatID()+ " nummer= "+ b.getNummer()+ " tripnr= "+ b.getTrip().getTripID());
        Trip trip = new Meer();
        trip.start();
        trip = tripRepository.save(trip);
        b.setTrip(trip);
        boatRepository.save(b);
        return trip;
    }

}



