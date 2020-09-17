package com.example.mysql;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class WelcomeNew extends AppCompatActivity {
    private TextView txtWel,txtep;
    private CardView cvCheckIn,cvCheckOut,cvAttendanceIn,cvChange,cvLogout,cvAttendanceOut;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_new);

        cvCheckIn =(CardView)findViewById(R.id.cvCheckIn);
        cvCheckOut =(CardView)findViewById(R.id.cvCheckOut);
        cvAttendanceIn =(CardView)findViewById(R.id.cvAttendanceIn);
        cvAttendanceOut =(CardView)findViewById(R.id.cvAttendanceOut);
        cvChange =(CardView)findViewById(R.id.cvChange);
        cvLogout =(CardView)findViewById(R.id.cvLogout);

        txtep =(TextView) findViewById(R.id.txtnewepf);




        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");

        // display the string into textView
        txtep.setText(str);

        Intent intent1 = getIntent();
        String str1 = intent.getStringExtra("message_key");

        // display the string into textView
        txtep.setText(str1);

        cvCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeNew.this,CheckIn.class));
                Toast.makeText(WelcomeNew.this,"Welcome To cecb",Toast.LENGTH_SHORT).show();

                String str = txtep.getText().toString();
                Intent intent = new Intent(getApplicationContext(), CheckIn.class);
                intent.putExtra("message_key", str);
                startActivity(intent);

            }
        });
        cvCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeNew.this,CheckOut.class));
                Toast.makeText(WelcomeNew.this,"Take care bye",Toast.LENGTH_SHORT).show();

                String str = txtep.getText().toString();
                Intent intent = new Intent(getApplicationContext(), CheckOut.class);
                intent.putExtra("message_key", str);
                startActivity(intent);

            }
        });
        cvAttendanceIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeNew.this, TodayRecodes.class));
                Toast.makeText(WelcomeNew.this,"Check your attendance",Toast.LENGTH_SHORT).show();

            }
        });
        cvAttendanceOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeNew.this, TodayRecodes.class));
                Toast.makeText(WelcomeNew.this,"Check your attendance",Toast.LENGTH_SHORT).show();

            }
        });
        cvChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeNew.this,UserEdit.class));
                Toast.makeText(WelcomeNew.this,"Change your password here",Toast.LENGTH_SHORT).show();

            }
        });
        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeNew.this,MainActivity.class));
                Toast.makeText(WelcomeNew.this,"Logout to Attendance recode app",Toast.LENGTH_SHORT).show();

            }
        });

        sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                //editor.putString(getResources().getString(R.string.prefStatus),"logout");
                editor.apply();
                startActivity(new Intent(WelcomeNew.this,MainActivity.class));
                finish();
            }
        });


    }


}