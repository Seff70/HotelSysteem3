package com.capgemini.Model.Kamers;

/**
 * Created by SAKUNNEN on 5-5-2017.
 */
public class Room {

    private int roomNumber;
    //private String guestLastName;
    private Etype roomType;


    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

//    public String getGuestLastName() {
//        return guestLastName;
//    }
//
//    public void setGuestLastName(String guestLastName) {
//        this.guestLastName = guestLastName;
//    }

    public Etype getRoomType() {
        return roomType;
    }

    public void setRoomType(Etype roomType) {
        this.roomType = roomType;
    }

}
