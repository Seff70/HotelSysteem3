package com.capgemini.Model.Boten;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Boat {

    @Id
    @GeneratedValue
    private int boatID;
    private int nummer;
    @OneToOne
    private Trip currentTrip;

    protected Boat() {
    }

    public Boat(int boatID, int nummer) {
        this.boatID = boatID;
        this.nummer = nummer;
    }

    public int getBoatID() {
        return boatID;
    }

    public int getNummer() {
        return nummer;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }

    @JsonProperty
    public Integer getCurrentTripID() {
        return currentTrip != null ? currentTrip.getTripID() : null;
    }
}


