package com.capgemini.controller;

import com.capgemini.Model.Boten.Trip;
import com.capgemini.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class TripController {

    @Autowired
    TripRepository tripRepository;

    @RequestMapping(value = "/api/Tochten", method = RequestMethod.GET)
    public List<Trip> tocht() throws SQLException {
        return tripRepository.findAll();
    }

    @RequestMapping(value = "/api/Tochten", method = RequestMethod.POST)
    public Trip addtochtlist(@RequestBody Trip trip) throws SQLException {
        return tripRepository.save(trip);
    }
}
