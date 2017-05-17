package com.capgemini.Model.Kamers;

/**
 * Created by SAKUNNEN on 5-5-2017.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private int roomID;
    private int roomNumber;
    private RoomType roomType;
    private boolean available;

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    private Date startDate;
    private Date endDate;

    public Room(){
    }

    public Room(int roomNumber, RoomType roomType, boolean available, Date startDate) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.available = available;
        this.startDate = startDate;
    }

    public int getRoomID() {
        return roomID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public boolean isAvailable() {
        return available;
    }
}


