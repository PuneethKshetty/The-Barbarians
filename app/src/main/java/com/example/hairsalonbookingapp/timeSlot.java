package com.example.hairsalonbookingapp;

public class timeSlot{
    private final String timeSlot;
    private Boolean available;

    //Constructor
    timeSlot(String timeSlot, Boolean available){
        this.timeSlot = timeSlot;
        this.available = available;
    }
    //Check Availability
    public Boolean isAvailable(){
        return available;
    }
}