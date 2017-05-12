package com.capgemini.controller;

import com.capgemini.Model.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;



@RestController
public class StatsController {

    @Autowired
    TripRepository tripRepository;

    @RequestMapping(value = "/api/stats", method = RequestMethod.GET)
    public ArrayList<String> getstats() throws SQLException {
        Stats s = new Stats();
        return s.stats();
    }
}
