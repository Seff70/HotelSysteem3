package com.capgemini.Model.Guests;

// define class Guest
public class Guest {

    // we geven het volgende mee
    private String name;
    private String address;
    private String zipcode;
    private String city;
    private String country;
    private String phonenumber;
    private String special;

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String woonplaats) {
        this.city = woonplaats;
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

    public Guest(){}
    public Guest(String name, String address, String zipcode, String city, String country, String phonenumber, String special){
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.phonenumber = phonenumber;
        this.special = special;
    }

    /**
     * Created by LMANNA on 3-5-2017.
     */
//    public static class Particulier extends Guest {
    }
//}
