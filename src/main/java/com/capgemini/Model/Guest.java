package com.capgemini.Model;

// define class Guest
public class Guest {

    // we geven het volgende mee
    private String name;
    private int age;

    // met setters en getters om data te retrieven
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
