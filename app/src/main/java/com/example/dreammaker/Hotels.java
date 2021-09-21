package com.example.dreammaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dreammaker.ApiClasss.APIInterface;
import com.example.dreammaker.ApiClasss.Apiclients;
import com.example.dreammaker.Babyshower.BabyShower_Decoraction;

import java.io.IOException;
import java.util.List;

import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Hotels extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.hotels_viewPage);
        Hotels_Adapter adapterView = new Hotels_Adapter(this);
        mViewPager.setAdapter(adapterView);


        Button button=findViewById(R.id.hotels_booking);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Hotels.this, Events_Booking_Details.class);
                startActivity(intent);
            }
        });


    }
}
