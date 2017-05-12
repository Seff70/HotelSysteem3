package com.capgemini.controller;


import com.capgemini.Model.StatsService;
import com.capgemini.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class StatsController {


    @Autowired
    StatsService statsService;

    @RequestMapping(value = "/api/stats", method = RequestMethod.GET)
    public ArrayList<String> getStatistics() throws SQLException {

        return statsService.stats();
    }
}
