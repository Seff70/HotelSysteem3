package com.capgemini.controller;

import com.capgemini.Model.Boten.Boat;
import com.capgemini.Model.Boten.Meer;
import com.capgemini.Model.Boten.Rivier;
import com.capgemini.Model.Boten.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;


@Service
public class TripRepository {

    @Autowired
    DataSource dataSource;

    @Autowired
    BoatRepository boatRepository;


    public List<Trip> getAllTrips() throws SQLException {
        ArrayList<Trip> tripList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
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
        try (Connection connection = dataSource.getConnection()) {
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
        int boatID = rs.getInt( "BoatID" );
        Boat boat = boatRepository.getBoat( boatID );
        int bootnummer = boat.getNummer();
        LocalDateTime endTime;
        if (endTimestamp != null) {
            endTime = endTimestamp.toLocalDateTime();
        } else {
            endTime = null;
        }

        String type = rs.getString( "type" );
        if ("Meer".equals( type )) {
            return new Meer( tripID, startTime.toLocalDateTime(), endTime, bootnummer);
        } else if ("Rivier".equals( type )) {
            return new Rivier( tripID, startTime.toLocalDateTime(), endTime, bootnummer);
        } else {
            throw new IllegalArgumentException( "Geen geldig type tocht: " + type );
        }


    }

    public boolean addTrip(Trip trip) throws SQLException{
<<<<<<< HEAD
        Boat boat = boatRepository.findBoat( trip.getBootnummer() );
        try (Connection connection = databaseService.getConnection("hotel2")) {
            try (PreparedStatement statement = connection.prepareStatement("insert into Trip (startTime, endTime,BoatID,type) VALUES (?,?,?,?)")) {
                statement.setTimestamp(1, Timestamp.valueOf( trip.getStartTime() ));
                statement.setTimestamp(2, Timestamp.valueOf( trip.getEndTime() ));
                statement.setInt(3, boat.getBoatID());
                statement.setString( 4, trip.getClass().getSimpleName() );
=======
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("insert into Trip (TripID, startTime, endTime,BoatID) VALUES (?,?,?,?)");) {
                statement.setInt(1, trip.getTripID());
                statement.setTimestamp(2, Timestamp.valueOf( trip.getStarttime() ));
                statement.setTimestamp(3, Timestamp.valueOf( trip.getEndtime() ));
                statement.setInt(3, trip.getBootnummer());

>>>>>>> origin/master
                int result = statement.executeUpdate();
                return result>0;
            }

        }


    }


}
