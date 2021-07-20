package com.example.hairsalonbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (getSupportActionBar() != null)  //remove top actionbar
        {
            getSupportActionBar().hide();
        }

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

        fAuth = FirebaseAuth.getInstance();


        btn1.setOnClickListener(v -> {
            Toast.makeText(Home.this,"Book an Appointment with our Barbers",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Home.this,Appointment.class));
        });
        btn2.setOnClickListener(v -> {
            Toast.makeText(Home.this,"Professional Based Services provided",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Home.this,Services.class));
        });
        btn3.setOnClickListener(v -> {
            Toast.makeText(Home.this,"Booking Details are present here",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Home.this,Notification.class));
        });
        btn4.setOnClickListener(v -> {
            Toast.makeText(Home.this,"Know More About Us",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Home.this,Barber.class));
        });
        btn5.setOnClickListener(v -> {
            Toast.makeText(Home.this,"Follow the Trends in Hair Style Industries",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Home.this,Trends.class));
        });
        btn6.setOnClickListener(v -> {
            fAuth.signOut();
            Toast.makeText(Home.this,"Successful Log Out",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Home.this,Login.class));
            finish();
        });
    }

}
