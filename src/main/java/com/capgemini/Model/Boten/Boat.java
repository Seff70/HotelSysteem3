package com.capgemini.Model.Boten;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by JVERDUIJ on 5-5-2017.
 */

@Entity
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boatID;
    private int nummer;
    
    protected Boat() {}

    public Boat(int boatID, int nummer) {
        this.boatID = boatID;
        this.nummer = nummer;
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
