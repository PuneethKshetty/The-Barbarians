package com.example.hairsalonbookingapp;

public class Book {

    String date;
    String time;
    String barber;

    public Book(String date,String time, String barber){
        this.date = date;
        this.time = time;
        this.barber = barber;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getBarber() {
        return barber;
    }
}
