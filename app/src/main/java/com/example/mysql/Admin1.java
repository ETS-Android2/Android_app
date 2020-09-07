package com.example.mysql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
public class Admin1 extends AppCompatActivity {

    private CardView cvEdit,cvRemove,cvToday,cvAll,cvChange,cvLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin1);

        cvEdit = findViewById(R.id.Adminedit);
        cvRemove = findViewById(R.id.AdminRemove);
        cvToday = findViewById(R.id.cvAttendanceIn);
        cvAll = findViewById(R.id.cvAttendanceOut);
        cvChange = findViewById(R.id.cvChange);
        cvLogout = findViewById(R.id.cvLogout);

        cvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin1.this, EditProfile.class));

            }
        });
        cvRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin1.this, UserList.class));

            }
        });
        cvToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin1.this, TodayRecodes.class));

            }
        });
        cvChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin1.this, EditProfile.class));

            }
        });
        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin1.this, MainActivity.class));

            }
        });
        cvAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin1.this, TodayRecodes.class));

            }
        });



    }
}