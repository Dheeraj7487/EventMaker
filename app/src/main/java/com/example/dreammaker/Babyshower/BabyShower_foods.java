package com.example.dreammaker.Babyshower;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dreammaker.Events_Booking_Details;
import com.example.dreammaker.ImageAdapter;
import com.example.dreammaker.R;

public class BabyShower_foods extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_shower_foods);
        getSupportActionBar().hide();

        ViewPager mViewPager = (ViewPager) findViewById(R.id.baby_food_viewPage);
        ImageAdapter adapterView = new ImageAdapter(this);
        mViewPager.setAdapter(adapterView);

        button=findViewById(R.id.baby_food_booking);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BabyShower_foods.this, Events_Booking_Details.class);
                startActivity(intent);
            }
        });
    }
}
