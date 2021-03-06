package com.capgemini.controller;

import com.capgemini.Model.Boat;
import com.capgemini.Model.Boten.PriceCalc;
import com.capgemini.Model.Meer;
import com.capgemini.Model.Rivier;
import com.capgemini.Model.Trip;
import com.capgemini.repository.BoatRepository;
import com.capgemini.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalTime;


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

    @RequestMapping(value = "/api/priceCalc", method = RequestMethod.GET)
    public Integer priceCalc() throws SQLException {
//    return new PriceCalc().berekenPrijs(25, LocalTime.now(), LocalTime.of( 0,30 ),Duration.ZERO);
return 100;
    }
//
//    @RequestMapping(value = "/api/getTotalNumberTrips", method = RequestMethod.GET)
//    public Iterable<Boat> boot() throws SQLException {
//        return boatRepository.findAll();
//    }

}



