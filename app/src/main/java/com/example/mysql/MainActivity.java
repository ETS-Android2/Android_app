package com.example.mysql;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView tvRegister,txtForget;
    private EditText etLoginPassword, etEPF;
    private Button loginButton;
    CheckBox checkedStatus;

    public static final int CONNECTION_TIMEOUT=10000;
    public static final int READ_TIMEOUT=15000;



    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ComponentType object = (ComponentType)findViewById(R.id.IdOfTheComponent);

        tvRegister = findViewById(R.id.tvRegister);
        txtForget = findViewById(R.id.txtForget);
        etEPF = findViewById(R.id.etEPF);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        loginButton = findViewById(R.id.btnLogin);
        checkedStatus = findViewById(R.id.checkbox);


        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
                finish();
            }
        });

        txtForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PasswordChange.class));
                finish();
            }
        });
        sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String loginStatus = sharedPreferences.getString(getResources().getString(R.string.pref_login_status),"");
        if (loginStatus.equals("Logged in")){
            startActivity(new Intent(MainActivity.this,Welcome.class));
            finish();

        }
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String epf = etEPF.getText().toString();
                String password = etLoginPassword.getText().toString();
                if (TextUtils.isEmpty(epf) || TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this,"All Fields are required",Toast.LENGTH_SHORT).show();
                }
                else {
                    login(epf,password);

                }
            }
        });

        }
    private void login(final String epf, final String password){
        final ProgressDialog progressDialog = new  ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Finding your account");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        String url = "http://roshanpriyankara.com/cecbatt/login1.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Login Success")) {
                    Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    startActivity(new Intent(MainActivity.this, WelcomeNew.class));
                    progressDialog.dismiss();
                    finish();

                    String str = etEPF.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), WelcomeNew.class);
                    intent.putExtra("message_key", str);
                    startActivity(intent);

                }else if (epf.equals("admin") || password.equals("admin")){
                    startActivity(new Intent(MainActivity.this, Admin1.class));
                    Toast.makeText(MainActivity.this,"Admin Login",Toast.LENGTH_SHORT).show();

                }
                    else {
                    Toast.makeText(MainActivity.this, "Password or EPF number incorrect",Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }

    }){
            protected Map<String, String>getParams() throws AuthFailureError{
                HashMap<String,String> param = new HashMap<>();
                param.put("epf",epf);
                param.put("password",password);
                return param;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(30000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getInstance(MainActivity.this).addToRequestQueue(request);


    }
}