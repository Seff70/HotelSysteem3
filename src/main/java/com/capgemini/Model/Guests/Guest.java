package com.capgemini.Model.Guests;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Guest {

    @Id
    @GeneratedValue
    private int guestID;
    private String name;
    private String address;
    private String zipcode;
    private String city;
    private String country;
    private String phonenumber;
    private String special;

    public int getGuestID() {
        return guestID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getSpecial() {
        return special;
    }
}
