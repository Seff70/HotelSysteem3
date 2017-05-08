package com.capgemini.controller;
import com.capgemini.Model.Boten.Boot;
import com.capgemini.Model.Guests.Guest;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;


@RestController
public class BootController extends AbstractDatabaseController {

    @RequestMapping(value = "/api/boot", method= RequestMethod.GET )
    public ArrayList<Boot> boot() throws SQLException{

        Connection connection = getConnection("hotel2");
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



