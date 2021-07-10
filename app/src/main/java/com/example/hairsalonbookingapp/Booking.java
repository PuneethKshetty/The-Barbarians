package com.example.hairsalonbookingapp;

public class Booking {

    String id;
    String date;
    String time;
    String barber;

    public Booking(String id,String date,String time, String barber){
        this.id =id;
        this.date = date;
        this.time = time;
        this.barber = barber;
    }

    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }


    public String getBarber() {
        return barber;
    }
    public void setBarber(String barber){
        this.barber = barber;
    }

}
