package com.capgemini.Model.Boten;

import java.time.LocalDateTime;

/**
 * Created by Skucukde on 9-5-2017.
 */
public class Meer extends Trip {


    public Meer(int tripID, LocalDateTime startTime, LocalDateTime endTime, int BoatID) {
        super(tripID,startTime,endTime,BoatID);
    }

}
