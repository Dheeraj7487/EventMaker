package com.example.dreammaker.Babyshower;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dreammaker.Baby_Photo_Adapter;
import com.example.dreammaker.Events_Booking_Details;
import com.example.dreammaker.ImageAdapter;
import com.example.dreammaker.R;

public class BabyShower_Photo extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_shower__photo);
        getSupportActionBar().hide();

        ViewPager mViewPager = (ViewPager) findViewById(R.id.baby_photo_viewPage);
        Baby_Photo_Adapter adapterView = new Baby_Photo_Adapter(this);
        mViewPager.setAdapter(adapterView);

        button=findViewById(R.id.baby_photo_booking);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BabyShower_Photo.this, Events_Booking_Details.class);
                startActivity(intent);
            }
        });

    }
}
