package com.capgemini.controller;

import com.capgemini.Model.Boten.Meer;
import com.capgemini.Model.Boten.Rivier;
import com.capgemini.Model.Boten.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TripController {

    @Autowired
    DatabaseService databaseService;

    @Autowired
    TripRepository Eric;

    @RequestMapping(value = "/api/Tochten", method = RequestMethod.GET)
    public List<Trip> tocht() throws SQLException {
    return Eric.getAllTrips();
    }

}