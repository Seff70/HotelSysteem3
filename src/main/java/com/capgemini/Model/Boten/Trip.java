package com.capgemini.Model.Boten;


import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.Duration;
import java.time.LocalDateTime;


@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, property = "type")
public abstract class Trip {

    private int tripID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int bootnummer;

    public int getBootnummer() {
        return bootnummer;
    }

    public void setBootnummer(int bootnummer) {
        this.bootnummer = bootnummer;
    }

    public Trip(int tripID, LocalDateTime startTime, LocalDateTime endTime, int bootnummer) {
        this.bootnummer = bootnummer;
        this.tripID = tripID;
        this.startTime = startTime;
        this.endTime = endTime;


    }

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    boolean start() {
        if (startTime == null) {
            startTime = LocalDateTime.now();
            return (true);
        } else {
            return false;
        }
    }

    boolean stop() {
        if (endTime == null) {
            endTime = LocalDateTime.now();
            return (true);
        } else {
            return false;
        }
    }

    Duration getDuur() {
        if (startTime != null && endTime != null) {
            return Duration.between( startTime, endTime );
        } else {
            return Duration.ZERO;
        }
    }
}
