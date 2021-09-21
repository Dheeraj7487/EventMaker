package com.example.dreammaker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class HomePage extends AppCompatActivity {

    String[] name = {"Profile", "Past Events", "Events", "Hotels", "FeedBack", "Contact Us", "Share", "LogOut"};
    int[] image = {R.drawable.profilelogo, R.drawable.eventslogo, R.drawable.eventslogo, R.drawable.hotel, R.drawable.feedbacklogo, R.drawable.contact, R.drawable.sharelogo, R.drawable.logoutlogo};
    GridView gridView;
    SharedPreferences sp;
    String sId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        gridView = findViewById(R.id.home_grid);

        Toast.makeText(this, sId, Toast.LENGTH_SHORT).show();

        ABAdapter aabbAdapter = new ABAdapter(HomePage.this, name, image);
        gridView.setAdapter(aabbAdapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(HomePage.this,AddPlanerdata.class);
                startActivity(intent);

            }
        });

    }
}