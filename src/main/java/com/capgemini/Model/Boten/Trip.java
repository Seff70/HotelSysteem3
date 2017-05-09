package com.capgemini.Model.Boten;


import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.Duration;
import java.time.LocalDateTime;


@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, property = "type")
public abstract class Trip {

    private int tripID;
    private LocalDateTime starttime;
    private LocalDateTime endtime;
    private int bootnummer;

    public int getBootnummer() {
        return bootnummer;
    }

    public void setBootnummer(int bootnummer) {
        this.bootnummer = bootnummer;
    }

    public Trip(int tripID, LocalDateTime startTime, LocalDateTime endTime, int BoatID) {
        this.bootnummer = BoatID;
        this.tripID = tripID;
        this.starttime = startTime;
        this.endtime = endTime;


    }


    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
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

    boolean start() {
        if (starttime == null) {
            starttime = LocalDateTime.now();
            return (true);
        } else {
            return false;
        }
    }

    boolean stop() {
        if (endtime == null) {
            endtime = LocalDateTime.now();
            return (true);
        } else {
            return false;
        }
    }

    Duration getDuur() {
        if (starttime != null && endtime != null) {
            return Duration.between( starttime, endtime );
        } else {
            return Duration.ZERO;
        }
    }
}
