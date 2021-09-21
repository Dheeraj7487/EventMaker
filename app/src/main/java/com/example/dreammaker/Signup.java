package com.example.dreammaker;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class Signup extends AppCompatActivity {

   // private static final int PICK_IMAGE = 1;
    //Uri imageUri;
    EditText name, number, email, password, address, confirm_pass;
    Button sbtn;
   // private // CircleImageView ProfileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //ProfileImage = findViewById(R.id.Profile_Image);
        name = findViewById(R.id.signup_name);
        number = findViewById(R.id.signup_number);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        address = findViewById(R.id.signup_address);
        confirm_pass = findViewById(R.id.signup_ConfirmPaaword);
        sbtn = findViewById(R.id.signup_btn);

        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name.getText().toString().isEmpty()) {
                    name.setError("Enter Your Name");
                } else if (number.getText().toString().isEmpty()) {
                    number.setError("Enter Your Number");
                } else if (email.getText().toString().isEmpty()) {
                    email.setError("Enter Your Email");
                } else if (password.getText().toString().isEmpty()) {
                    password.setError("Enter Your Password");

                } else if (address.getText().toString().isEmpty()) {
                    address.setError("Enter Your Address");
                } else if (confirm_pass.getText().toString().isEmpty()) {
                    confirm_pass.setError("Enter Your Conform_Password");

                    if (!confirm_pass.equals(password)) {
                        Toast.makeText(Signup.this, "Password do not match", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Signup.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                }
                    if (new ConnectionCall(Signup.this).isConnectingToInternet()) {
                        new Registerpage().execute();
                    } else new ConnectionCall(Signup.this).connectiondetect();
                }
        });

    }
    private class Registerpage extends AsyncTask<String, String, String> {

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(Signup.this);
            pd.setMessage("Loading...");
            pd.show();
        }

     //   @SuppressLint("WrongThread")
        @Override
        protected String doInBackground(String... strings) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", name.getText().toString());
            hashMap.put("number", number.getText().toString());
            hashMap.put("email", email.getText().toString());
            hashMap.put("password", password.getText().toString());
            hashMap.put("address", address.getText().toString());


            return new MakeServiceCall().MakeServiceCall("https://dreammakers1.000webhostapp.com/signup.php", MakeServiceCall.POST, hashMap);

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (pd.isShowing()) {
                pd.dismiss();
            }

            try {

                JSONObject jsonObject = new JSONObject(s);
                if (jsonObject.getString("Status").equalsIgnoreCase("True")) {
                    Toast.makeText(Signup.this, "Register Successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Signup.this, Login.class);
                    startActivity(intent);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}