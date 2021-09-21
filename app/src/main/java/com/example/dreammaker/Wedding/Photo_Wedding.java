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
import com.example.dreammaker.wedding_photo_adapter;

public class Photo_Wedding extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo__wedding);
        getSupportActionBar().hide();


        ViewPager mViewPager = (ViewPager) findViewById(R.id.wedding_photo_viewPage);
        wedding_photo_adapter adapterView = new wedding_photo_adapter(this);
        mViewPager.setAdapter(adapterView);

        button=findViewById(R.id.wedding_photo_booking);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Photo_Wedding.this, Events_Booking_Details.class);
                startActivity(intent);
            }
        });
    }
}
