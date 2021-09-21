package com.example.dreammaker.Babyshower;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dreammaker.Baby_Photo_Adapter;
import com.example.dreammaker.Baby_Place_Adapter;
import com.example.dreammaker.Events_Booking_Details;
import com.example.dreammaker.R;

public class BabyShower_Place extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_shower__place);
        getSupportActionBar().hide();

        ViewPager mViewPager = (ViewPager) findViewById(R.id.baby_place_viewPage);
        Baby_Place_Adapter adapterView = new Baby_Place_Adapter(this);
        mViewPager.setAdapter(adapterView);


        button=findViewById(R.id.baby_place_booking);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BabyShower_Place.this, Events_Booking_Details.class);
                startActivity(intent);
            }
        });

    }
}
