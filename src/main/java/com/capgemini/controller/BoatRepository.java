package com.capgemini.controller;

import com.capgemini.Model.Boten.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoatRepository {

//    @Autowired
//    DatabaseService databaseService;

    @Autowired
    DataSource dataSource;

    public List<Boat> getAllBoats() throws SQLException {
        ArrayList<Boat> boatList = new ArrayList <>();
        try (Connection connection = dataSource.getConnection()){
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Boat")){
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        boatList.add( (Boat) rs );
                    }
                }
            }
        }
        return boatList;
    }

    public Boat getBoat(int id) throws SQLException {
        try (Connection connection = dataSource.getConnection()){
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Boat WHERE BoatID = ?")){
                statement.setInt(1, id);
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        return mapBoat(rs);
                    }
                }
            }
        }
        return null;
    }

    private Boat mapBoat(ResultSet rs) throws SQLException {
        int boatnumber = rs.getInt("boatnumber");
        Boat boat = new Boat();
        boat.setNummer( boatnumber );
        return boat;
    }

}
