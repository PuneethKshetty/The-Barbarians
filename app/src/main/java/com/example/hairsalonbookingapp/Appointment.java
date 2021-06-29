package com.example.hairsalonbookingapp;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Spliterator;

public class Appointment extends AppCompatActivity {

    EditText date_in;
    EditText time_in;
    Spinner spinnerName;
    Button btnInsertData,button2;

    DatabaseReference studentDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        if (getSupportActionBar() != null)  //remove top actionbar
        {
            getSupportActionBar().hide();
        }
        date_in = findViewById(R.id.date_input);
        time_in = findViewById(R.id.time_input);
        spinnerName = findViewById(R.id.spinner);
        btnInsertData = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        studentDbRef = FirebaseDatabase.getInstance().getReference().child("Book");

        btnInsertData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String date = date_in.getText().toString().trim();
                String time = time_in.getText().toString().trim();
                String barber = spinnerName.getSelectedItem().toString().trim();

                if (TextUtils.isEmpty(date)) {
                    date_in.setError("Add a Appointment Date");
                    return;
                }
                if (TextUtils.isEmpty(time)) {
                    time_in.setError("Add a Appointment Date");
                    return;
                }
                    insertBarberData();
                    Toast.makeText(Appointment.this, "Appointment is Booked Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Appointment.this, Notification.class));
                }
        });

        date_in.setInputType(InputType.TYPE_NULL);
        time_in.setInputType(InputType.TYPE_NULL);


        date_in.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                showDateDialog(date_in);
            }
        });
        time_in.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                showTimeDialog(time_in);
            }
        });
    }
        private void insertBarberData () {
            String date = date_in.getText().toString();
            String time = time_in.getText().toString();
            String barber = spinnerName.getSelectedItem().toString();

            Book book = new Book(date, time, barber);

            //new record insertion (new id gen)
            studentDbRef.push().setValue(book).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull  Task<Void> task) {
                    Toast.makeText(Appointment.this, "Appointment is Booked Successfully", Toast.LENGTH_SHORT).show();
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {  //button 2 here
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Appointment.this, Notification.class));
                }
            });

        }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showTimeDialog(final EditText time_in) {
        final Calendar calendar=Calendar.getInstance();
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                calendar.set(Calendar.MINUTE,minute);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm",Locale.getDefault());
                time_in.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
         new TimePickerDialog(Appointment.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showDateDialog(final EditText date_in){
       final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view,int year,int month, int dayofMonth){
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayofMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                date_in.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
          new DatePickerDialog(Appointment.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();

    }

}
