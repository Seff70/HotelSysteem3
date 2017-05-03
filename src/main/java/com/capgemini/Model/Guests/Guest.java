package com.capgemini.Model.Guests;

// define class Guest
public class Guest {

    // we geven het volgende mee
    private String name;
    private String address;
    private String zipcode;
    private String woonplaats;
    private String country;
    private String phonenumber;

    // met setters en getters om data te retrieven
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }


    /**
     * Created by LMANNA on 3-5-2017.
     */
    public static class Particulier extends Guest {
    }
}
