package com.capgemini.controller;

import com.capgemini.Model.Boten.Meer;
import com.capgemini.Model.Boten.Rivier;
import com.capgemini.Model.Boten.Trip;
import com.capgemini.Model.Guests.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class TripRepository {

    @Autowired
    DatabaseService databaseService;

    @Autowired
    BoatRepository boatRepository;


    public List<Trip> getAllTrips() throws SQLException {
        ArrayList<Trip> tripList = new ArrayList<>();
        try (Connection connection = databaseService.getConnection( "hotel2" )) {
            try (PreparedStatement statement = connection.prepareStatement( "SELECT * FROM Trip" )) {
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        tripList.add( mapTrip( rs ) );

                    }
                }
            }
        }
        return tripList;
    }

    public Trip getTrip(int id) throws SQLException {
        try (Connection connection = databaseService.getConnection( "hotel2" )) {
            try (PreparedStatement statement = connection.prepareStatement( "SELECT * FROM Trip WHERE TripID = ?" )) {
                statement.setInt( 1, id );
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        return mapTrip( rs );
                    }
                }
            }
        }
        return null;
    }

    private Trip mapTrip(ResultSet rs) throws SQLException {
        int tripID = rs.getInt( "TripID" );
        Timestamp startTime = rs.getTimestamp("startTime");
        Timestamp endTimestamp = rs.getTimestamp( "endTime" );
        int Bootnummer = rs.getInt( "BoatID" );
        LocalDateTime endTime;
        if (endTimestamp != null) {
            endTime = endTimestamp.toLocalDateTime();
        } else {
            endTime = null;
        }

        String type = rs.getString( "type" );
        if (type.equals( "Meer" )) {
            return new Meer( tripID, startTime.toLocalDateTime(), endTime, Bootnummer);
        } else if (type.equals( "Rivier" )) {
            return new Rivier( tripID, startTime.toLocalDateTime(), endTime, Bootnummer);
        } else {
            throw new IllegalArgumentException( "Geen gelding invoer" );
        }

    }
}
