package com.capgemini.Model.Boten;

/**
 * Created by JVERDUIJ on 5-5-2017.
 */
public class Boat {
    private int boatID;
    private int nummer;

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
