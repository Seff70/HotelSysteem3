package com.capgemini.Model;

import com.capgemini.Model.Trip;

import javax.persistence.*;

@Entity
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boatID;
    private int nummer;
    @OneToOne
    private Trip currentTrip;

    protected Boat() {}

    public Boat(int boatID, int nummer) {
        this.boatID = boatID;
        this.nummer = nummer;
    }

    public Trip getTrip() {
        return currentTrip;
    }

    public void setTrip(Trip trip) {
        this.currentTrip = trip;
    }

//    public int getBoatID() {
//        return boatID;
//    }
//
//    public void setBoatID(int boatID) {
//        this.boatID = boatID;
//    }

    public int getNummer() {
        return nummer;
    }

//    public void setNummer(int nummer) {
//        this.nummer = nummer;
//    }

}


