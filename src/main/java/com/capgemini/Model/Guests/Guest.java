package com.capgemini.Model.Guests;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guest {

    // we geven het volgende mee
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int GuestID;

    private String name;
    private String address;
    private String zipcode;
    private String city;
    private String country;
    private String phonenumber;
    private String special;


    public int getGuestID() {
        return GuestID;
    }

    public String getSpecial() {
        return special;
    }

    // met setters en getters om data te retrieven
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

    protected Guest() {
    }

    public Guest(String name, String address, String zipcode, String city, String country, String phonenumber, String special) {
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.phonenumber = phonenumber;
        this.special = special;
    }
}
