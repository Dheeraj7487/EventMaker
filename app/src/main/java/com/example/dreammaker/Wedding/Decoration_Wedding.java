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
import com.example.dreammaker.wedding_decoration_adapter;

public class Decoration_Wedding extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoration__wedding);
        getSupportActionBar().hide();


        ViewPager mViewPager = (ViewPager) findViewById(R.id.wedding_deco_viewPage);
        wedding_decoration_adapter adapterView = new wedding_decoration_adapter(this);
        mViewPager.setAdapter(adapterView);

        button=findViewById(R.id.wedding_deco_booking);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Decoration_Wedding.this, Events_Booking_Details.class);
                startActivity(intent);
            }
        });
    }
}
