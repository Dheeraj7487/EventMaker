package com.example.dreammaker.Wedding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dreammaker.Babyshower.BabyShower_foods;
import com.example.dreammaker.Events_Booking_Details;
import com.example.dreammaker.R;
import com.example.dreammaker.Ring_Foods_Adapter;
import com.example.dreammaker.wedding_place_adapter;

public class Place_Wedding extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place__wedding);
        getSupportActionBar().hide();


        ViewPager mViewPager = (ViewPager) findViewById(R.id.wedding_place_viewPage);
        wedding_place_adapter adapterView = new wedding_place_adapter(this);
        mViewPager.setAdapter(adapterView);

        button=findViewById(R.id.wedding_place_booking);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Place_Wedding.this, Events_Booking_Details.class);
                startActivity(intent);
            }
        });
    }
}
