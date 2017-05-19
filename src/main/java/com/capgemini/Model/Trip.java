package com.capgemini.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@DiscriminatorColumn(name = "type")
public abstract class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tripID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    public int prijs;

    protected Trip() {
    }

    public Trip(int tripID, LocalDateTime startTime, LocalDateTime endTime, int prijs) {
        this.tripID = tripID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.prijs = prijs;
    }

    public Trip(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getTripID() {
        return tripID;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public boolean start() {
        if (startTime == null) {
            startTime = LocalDateTime.now();
            return (true);
        } else {
            return false;
        }
    }

    public boolean stop() {
        if (endTime == null) {
            endTime = LocalDateTime.now();
            return (true);
        } else {
            return false;
        }
    }

//    public LocalDateTime formatter() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy, hh:mm");
//        String text = startTime.format(formatter);
//        LocalDateTime parsedStartTime = LocalDateTime.parse(text, formatter);
//        return parsedStartTime;
//    }

    @JsonProperty
    public Duration getDuur() {
        if (startTime != null && endTime != null) {
            return Duration.between(startTime, endTime);
        } else {
            return Duration.ZERO;
        }
    }

    @JsonProperty
    public String getType() {
        return getClass().getSimpleName();
    }

}
