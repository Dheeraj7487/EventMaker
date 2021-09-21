package com.example.dreammaker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Profile extends AppCompatActivity {

    TextView name, number, email, address;
    ImageView profile;
    SharedPreferences sp;
    String sId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile = findViewById(R.id.profile_image);

        name = findViewById(R.id.profile_name);
        number = findViewById(R.id.profile_number);
        email = findViewById(R.id.profile_email);
        address = findViewById(R.id.profile_address);

        sp = getSharedPreferences(ConstantsSp.PREF, MODE_PRIVATE);

        name.setText(sp.getString(ConstantsSp.NAME,""));
        number.setText(sp.getString(ConstantsSp.NUMBER,""));
        email.setText(sp.getString(ConstantsSp.EMAIL,""));
        address.setText(sp.getString(ConstantsSp.ADDRESS,""));


        }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Profile.this,HomePage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    }

