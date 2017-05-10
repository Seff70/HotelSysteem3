package com.capgemini.controller;

import com.capgemini.Model.Boten.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class BoatController {

    @Autowired
    BoatRepository boatRepository;

    @RequestMapping(value = "/api/boot", method= RequestMethod.GET )
    public List<Boat> boot() throws SQLException{
        return boatRepository.getAllBoats();
    }


}



