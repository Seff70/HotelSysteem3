package com.capgemini.Model.Boten;

import java.time.Duration;

/**
 * Created by Skucukde on 9-5-2017.
 */
public class Rivier extends Tocht {
    public Rivier(){

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
