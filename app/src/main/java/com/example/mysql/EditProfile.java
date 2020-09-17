package com.example.mysql;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.HashMap;

public class EditProfile extends Activity {
    private Button btnRemove, btnEdit, btnusers;
    TextView txtCancel;
    private EditText editEPF, editName, editEmail, editPassword;



    // url to update users
    private static final String url_update_product = "https://192.168.61.80:84/try/update_user.php";

    // url to delete users
    private static final String url_delete_product = "https://192.168.61.80:84/try/DeleteUser.php";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editEPF = findViewById(R.id.etEditEPF);
        editName = findViewById(R.id.etEditName);
        editEmail = findViewById(R.id.etEditGmail);
        editPassword = findViewById(R.id.etEditPassword);
        btnRemove = findViewById(R.id.btnRemove);
        btnEdit = findViewById(R.id.btnEdit);
        txtCancel = findViewById(R.id.btncancel);

        txtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditProfile.this, Admin1.class));

            }
        });

    }



    //Update Users
    public void update_user(View view){
        final String epf = editEPF.getText().toString();
        final String name = editName.getText().toString();
        final String email = editEmail.getText().toString();
        final String password = editPassword.getText().toString();



        class Update extends AsyncTask<Void, Void, String>{
            ProgressDialog pdLoading = new ProgressDialog(EditProfile.this);

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                //this method will be running on UI thread
                pdLoading.setMessage("\tLoading...");
                pdLoading.setCancelable(false);
                pdLoading.show();
            }

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler1 requestHandler = new RequestHandler1();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("epf", epf);
                params.put("name",name);
                params.put("email", email);
                params.put("password",password);

                //returing the response
                return requestHandler.sendPostRequest(url_update_product, params);
            }

            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                pdLoading.dismiss();

                try{
                    //Converting response to JSON Object
                    JSONObject obj = new JSONObject(s);

                    //if no error in response
                    if (!obj.getBoolean("error")){
                        Toast.makeText(EditProfile.this, obj.getString("message"), Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e ){
                    Toast.makeText(EditProfile.this, "Exception: "+e, Toast.LENGTH_SHORT).show();
                }
            }
        }
        Update update = new Update();
        update.execute();
    }

    public void delete_user(View view){
        final String epf = editEPF.getText().toString();

        class Delete extends AsyncTask<Void, Void, String>{
            ProgressDialog pdLoading = new ProgressDialog(EditProfile.this);

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                //this method will be running on UI thread
                pdLoading.setMessage("\tLoading...");
                pdLoading.setCancelable(false);
                pdLoading.show();
            }

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler1 requestHandler = new RequestHandler1();


                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("epf", epf);

                //returing the response
                return requestHandler.sendPostRequest(url_delete_product, params);
            }

            @Override
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                pdLoading.dismiss();

                try{
                    //Converting response to JSON Object
                    JSONObject obj = new JSONObject(s);

                    //if no error in response
                    if (!obj.getBoolean("error")){
                        Toast.makeText(EditProfile.this, obj.getString("message"), Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e ){
                    Toast.makeText(EditProfile.this, "Exception: "+e, Toast.LENGTH_SHORT).show();
                }
            }
        }
        Delete delete = new Delete();
        delete.execute();

    }

}