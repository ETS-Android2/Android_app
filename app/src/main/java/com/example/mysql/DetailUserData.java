package com.example.mysql;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class DetailUserData extends AppCompatActivity {
TextView epf,name,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user_data);

        name = (TextView) findViewById(R.id.textname );
        email = (TextView) findViewById(R.id.textemail);
        password = (TextView) findViewById(R.id.textpassword);
        epf = (TextView) findViewById(R.id.textepf);

        epf.setText(getIntent().getStringExtra("epf"));
        name.setText(getIntent().getStringExtra("name"));
        email.setText(getIntent().getStringExtra("email"));
        password.setText(getIntent().getStringExtra("password"));
    }
}