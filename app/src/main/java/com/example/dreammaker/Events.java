package com.example.dreammaker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.dreammaker.Fragment.Babyshower;
import com.example.dreammaker.Fragment.Festival;
import com.example.dreammaker.Fragment.Ringceremony;
import com.example.dreammaker.Fragment.Wedding;

import com.google.android.material.tabs.TabLayout;

public class Events extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        getSupportActionBar().hide();

        tabLayout=findViewById(R.id.event_tab);
        viewPager=findViewById(R.id.event_viewpager);

        tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(new CustomAdapter (getSupportFragmentManager()));


    }

    private class CustomAdapter extends FragmentPagerAdapter {
        public CustomAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    return new Wedding();
                case 1:
                    return new Ringceremony();
                case 2:
                    return new Babyshower();
                case 3:
                    return new Festival();

            }


            return null;
        }


        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0:
                    return "Wedding";
                case 1:
                    return "Ring-ceremony";
                case 2:
                    return "Baby-Shower";
                case 3:
                    return "Festival";


            }


            return super.getPageTitle(position);
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}