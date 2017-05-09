package com.capgemini.controller;

import com.capgemini.Model.Boten.Boot;
import com.capgemini.Model.Boten.Meer;
import com.capgemini.Model.Boten.Rivier;
import com.capgemini.Model.Boten.Tocht;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Track;
import javax.xml.ws.Action;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
public class TochtController {


    @Autowired
    DatabaseService databaseService;

    @RequestMapping(value = "/api/Tochten", method = RequestMethod.GET)
    public ArrayList<Tocht> tocht() throws SQLException {

        Connection connection = databaseService.getConnection( "hotel2" );
        PreparedStatement statement = connection.prepareStatement( "SELECT * FROM Trip" );
        ResultSet rs = statement.executeQuery();

        ArrayList<Tocht> tochtenlist = new ArrayList<>();
        while (rs.next()) {
            int TripID = rs.getInt( "TripID" );
            LocalDateTime startTime = rs.getTimestamp( "startTime" ).toLocalDateTime();
            Timestamp endTimestamp = rs.getTimestamp( "endTime" );
            LocalDateTime endTime = null;
             if (endTimestamp != null) {
                 endTime = endTimestamp.toLocalDateTime();
             }
            String type = rs.getString( "type" );
            int BoatID = rs.getInt( "BoatID" );

            Tocht tocht;
            if (type.equals( "Meer" )) {
                tocht = new Meer();
            } else if (type.equals( "Rivier" )) {
                tocht = new Rivier();
            } else { throw new IllegalArgumentException ("Geen gelding invoer");
            } ;

            tocht.setTripnummer( TripID );
            tocht.setEndtime( endTime );
            tocht.setStarttime( startTime );

            tochtenlist.add( tocht );
        }
        return tochtenlist;

    }


}
