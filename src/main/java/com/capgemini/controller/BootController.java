package com.capgemini.controller;

import com.capgemini.Model.Boten.Boot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@RestController
public class BootController {

    @Autowired
    DatabaseService databaseService;

    @RequestMapping(value = "/api/boot", method= RequestMethod.GET )
    public ArrayList<Boot> boot() throws SQLException{

        Connection connection = databaseService.getConnection("hotel2");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Boat");
        ResultSet rs = statement.executeQuery();

        ArrayList<Boot> botenList = new ArrayList<>();
        while(rs.next()) {
            int Boatnumber = rs.getInt( "Boatnumber" );
            Boot boot = new Boot();
            boot.setNummer(Boatnumber);
            botenList.add(boot);

        }
        return botenList ;

    }


}



