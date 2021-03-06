package com.example.mad_a2;


import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button searchBtn = findViewById(R.id.searchBtn);

        searchBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double longitude, latitude;
                EditText lng = findViewById(R.id.longEditText);
                EditText lat = findViewById(R.id.lattEditText);
                TextView address = findViewById(R.id.addressTextView);
                longitude = Double.parseDouble(lng.getText().toString());
                latitude = Double.parseDouble(lat.getText().toString());
                Geocoder g = new Geocoder((getApplicationContext()),Locale.getDefault());

                List<Address> coords;
                try {
                    coords = g.getFromLocation(latitude,longitude , 1);
                    if (coords != null && coords.size() > 0) {
                        Address adr = (Address) coords.get(0);
                        address.setText("Address: " + adr.getAddressLine(0));

                    }
                } catch (Exception e) {
                    address.setText("Address: This location does not have an address, try again.");
                    e.printStackTrace();
                }


            }
        });
    }
}