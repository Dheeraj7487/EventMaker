package com.example.dreammaker.RingCermony;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dreammaker.Baby_Decoration_Adapter;
import com.example.dreammaker.Babyshower.BabyShower_foods;
import com.example.dreammaker.Events_Booking_Details;
import com.example.dreammaker.R;
import com.example.dreammaker.Ring_Place_Adapter;

public class RingCer_Place extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring_cer__place);
        getSupportActionBar().hide();

        ViewPager mViewPager = (ViewPager) findViewById(R.id.ring_place_viewPage);
        Ring_Place_Adapter adapterView = new Ring_Place_Adapter(this);
        mViewPager.setAdapter(adapterView);


        button=findViewById(R.id.ring_place_booking);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RingCer_Place.this, Events_Booking_Details.class);
                startActivity(intent);
            }
        });

    }
}
