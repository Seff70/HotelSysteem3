package com.capgemini.Model.Boten;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by Skucukde on 9-5-2017.
 */
public class Rivier extends Trip {

    public Rivier(int tripID, LocalDateTime startTime, LocalDateTime endTime, int BoatID) {
        super(tripID,startTime,endTime,BoatID);
    }


    @Override
    Duration getDuur(){
        Duration d = super.getDuur().minusMinutes( 30 );
        if (d.isNegative()){
            return Duration.ZERO;
        }
        else {
            return d;
        }

    }


}
