package com.capgemini.Model.Kamers;

/**
 * Created by SAKUNNEN on 5-5-2017.
 */
        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int roomNumber;
    private int roomNumberreal;
    private Etype roomType;
    private boolean availability = true;


    protected Room() {}

    public Room(int roomNumber, Etype roomType, int roomNumberreal, boolean availability) {
        this.roomNumber = roomNumber;
        this.roomType= roomType;
        this.roomNumberreal = roomNumberreal;
        this.availability = availability;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Etype getRoomType() {
        return roomType;
    }

    public int getRoomNumberreal() {return roomNumberreal;}

    public boolean getAvailability() {return availability;}


}


