package com.example.modelos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.modelos.Models.Product;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Date fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String date="01/08/2023";
        SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");

        try {
            fecha= format.parse(date);
            Log.i("Date", date);
            Log.i("Date Format", fecha.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }




        //  Product yogurt= new Product("L23","yogurt Fernando","Celema","Lacteos SA",8500.0,"01/08/2023");



    }
}