package com.example.hairsalonbookingapp;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class Barber extends AppCompatActivity {

    ImageButton imgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barber);

        if (getSupportActionBar() != null)  //remove top actionbar
        {
            getSupportActionBar().hide();
        }

        addListenerOnButton1();
        addListenerOnButton2();
        addListenerOnButton3();
        addListenerOnButton4();
        addListenerOnButton5();
        addListenerOnButton6();
        addListenerOnButton7();
        addListenerOnButton8();
    }

    private void addListenerOnButton1() {

        imgButton = (ImageButton) findViewById(R.id.youtube);

        imgButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.facebook.com.";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }

        });
    }
    private void addListenerOnButton2() {

        imgButton = (ImageButton) findViewById(R.id.facebook);

        imgButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.facebook.com.";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }

        });
    }


    private void addListenerOnButton3() {

        imgButton = (ImageButton) findViewById(R.id.google);

        imgButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.twitter.com.";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
    private void addListenerOnButton4() {
        imgButton = (ImageButton) findViewById(R.id.youtube1);

        imgButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.twitter.com.";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
    private void addListenerOnButton5(){
        imgButton = (ImageButton) findViewById(R.id.facebook1);

        imgButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.twitter.com.";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
private void addListenerOnButton6(){
    imgButton = (ImageButton) findViewById(R.id.google1);

    imgButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            String url = "http://www.twitter.com.";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
}
private void addListenerOnButton7(){
    imgButton = (ImageButton) findViewById(R.id.call);

    imgButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:1234567890"));
            startActivity(callIntent);
        }
    });
}
private void addListenerOnButton8(){
    imgButton = (ImageButton) findViewById(R.id.call1);

    imgButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:9876543210"));
            startActivity(callIntent);
        }
    });
}
}