package com.capgemini.Model.Boten;

import javax.persistence.*;

/**
 * Created by JVERDUIJ on 5-5-2017.
 */

@Entity
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boatID;
    private int nummer;
    @OneToOne
    private Trip trip;

    protected Boat() {
    }

    public Boat(int boatID, int nummer) {
        this.boatID = boatID;
        this.nummer = nummer;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public int getBoatID() {
        return boatID;
    }

    public void setBoatID(int boatID) {
        this.boatID = boatID;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

}


