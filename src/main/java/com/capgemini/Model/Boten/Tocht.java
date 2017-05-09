package com.capgemini.Model.Boten;


import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, property = "type")
public abstract class Tocht {


    private int tripnummer;
    private LocalDateTime starttime;
    private LocalDateTime endtime;
    private int Bootnummer;

    public int getTripnummer() {
        return tripnummer;
    }

    public void setTripnummer(int tripnummer) {
        this.tripnummer = tripnummer;
    }

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    public LocalDateTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }

    boolean start(){
        if (starttime == null) {
            starttime = LocalDateTime.now();
            return(true);
        } else {
            return false;
        }
    }

    boolean stop(){
        if (endtime == null) {
            endtime = LocalDateTime.now();
            return(true);
        } else {
            return false;
        }
    }

    Duration getDuur(){
        if(starttime != null && endtime != null) {
            return Duration.between( starttime, endtime );
        } else {
            return Duration.ZERO;
        }
    }

}
