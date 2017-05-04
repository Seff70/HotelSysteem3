package com.capgemini.Model.Kamers;


public class Kamer {
    public int getKamernummer()
    {
        return kamernummer;
    }


    public void setKamernummer(int kamernummer) {
        this.kamernummer = kamernummer;
    }

    private int kamernummer;

    public Etype gettype() {
        return type;
    }

    public void settype(Etype type) {
        this.type = type;
    }

    private Etype type;

}


