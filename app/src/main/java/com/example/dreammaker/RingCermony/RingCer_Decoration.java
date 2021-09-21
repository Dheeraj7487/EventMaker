package com.example.dreammaker.RingCermony;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dreammaker.Baby_Decoration_Adapter;
import com.example.dreammaker.Events_Booking_Details;
import com.example.dreammaker.R;
import com.example.dreammaker.Ring_Decoration_Adapter;

public class RingCer_Decoration extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring_cer__decoration);
        getSupportActionBar().hide();

        ViewPager mViewPager = (ViewPager) findViewById(R.id.ring_deco_viewPage);
        Ring_Decoration_Adapter adapterView = new Ring_Decoration_Adapter(this);
        mViewPager.setAdapter(adapterView);


        button=findViewById(R.id.ring_deco_booking);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RingCer_Decoration.this, Events_Booking_Details.class);
                startActivity(intent);
            }
        });

    }
}
