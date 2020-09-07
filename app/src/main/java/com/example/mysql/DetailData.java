package com.example.mysql;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailData extends AppCompatActivity {
    TextView epf, location, longitude, latitude,timeIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);

        epf = (TextView) findViewById(R.id.textViewShortDesc);
        location = (TextView) findViewById(R.id.textlocation);
        longitude = (TextView) findViewById(R.id.textlongitude );
        latitude = (TextView) findViewById(R.id.textlatitude);
        timeIn = (TextView) findViewById(R.id.texttimeIn);


        epf.setText(getIntent().getStringExtra("epf"));
        location.setText(getIntent().getStringExtra("location"));
        longitude.setText(getIntent().getStringExtra("longitude"));
        latitude.setText(getIntent().getStringExtra("latitude"));
        timeIn.setText(getIntent().getStringExtra("timeIn"));


    }
}
