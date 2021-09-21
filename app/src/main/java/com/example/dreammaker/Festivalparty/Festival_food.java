package com.example.dreammaker.Festivalparty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.dreammaker.Baby_Photo_Adapter;
import com.example.dreammaker.Festival_Food_Adapter;
import com.example.dreammaker.R;

public class Festival_food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_food);
        getSupportActionBar().hide();

        ViewPager mViewPager = (ViewPager) findViewById(R.id.festival_food_viewPage);
        Festival_Food_Adapter adapterView = new Festival_Food_Adapter(this);
        mViewPager.setAdapter(adapterView);

    }
}
