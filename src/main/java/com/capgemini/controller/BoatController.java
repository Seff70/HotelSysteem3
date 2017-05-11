package com.capgemini.controller;

import com.capgemini.Model.Boten.Boat;
import com.capgemini.Model.Boten.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
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

    @RequestMapping(value = "/api/newtrip", method = RequestMethod.GET)
    public Trip newTrip(Boat b){
//        Trip trip = new Trip(b);
//        return trip;
    }

}



