package com.capgemini.controller;

import com.capgemini.Model.Boten.Boat;
import com.capgemini.Model.Boten.Meer;
import com.capgemini.Model.Boten.Rivier;
import com.capgemini.Model.Boten.Trip;
import com.capgemini.repository.BoatRepository;
import com.capgemini.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@RestController
public class BoatController {

    @Autowired
    BoatRepository boatRepository;

    @Autowired
    TripRepository tripRepository;

    @RequestMapping(value = "/api/boats", method = RequestMethod.GET)
    public Iterable<Boat> boot() throws SQLException {
        return boatRepository.findAll();
    }

    @RequestMapping(value = "/api/boats/{boatID}/addlaketrip", method = RequestMethod.POST)
    public Trip newLakeTrip(@PathVariable int boatID) throws SQLException{
        Boat b = boatRepository.findOne(boatID);
        System.out.println("Bootgeg in controller: nummer= "+ b.getNummer());
        Trip trip = new Meer();
        trip.start();
        trip = tripRepository.save(trip);
        b.setTrip(trip);
        boatRepository.save(b);
        return trip;
    }

    @RequestMapping(value = "/api/boats/{boatID}/addrivertrip", method = RequestMethod.POST)
    public Trip newRiverTrip(@PathVariable int boatID) throws SQLException{
        Boat b = boatRepository.findOne(boatID);
        System.out.println("Bootgeg in controller: nummer= "+ b.getNummer());
        Trip trip = new Rivier();
        trip.start();
        trip = tripRepository.save(trip);
        b.setTrip(trip);
        boatRepository.save(b);
        return trip;
    }

    @RequestMapping(value = "/api/boats/{boatID}/endtrip", method = RequestMethod.POST)
    public Trip endTrip(@PathVariable int boatID) throws SQLException{
        Boat b = boatRepository.findOne(boatID);
        System.out.println("Bootgeg in controller eindig trip: nummer= "+ b.getNummer());
        Trip trip = b.getTrip();
        trip.stop();
        trip = tripRepository.save(trip);
        b.setTrip(null);
        boatRepository.save(b);
        return trip;
    }
//
//    @RequestMapping(value = "/api/getTotalNumberTrips", method = RequestMethod.GET)
//    public Iterable<Boat> boot() throws SQLException {
//        return boatRepository.findAll();
//    }

}



