package com.example.dreammaker.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dreammaker.Babyshower.BabyShower_Decoraction;
import com.example.dreammaker.Babyshower.BabyShower_Photo;
import com.example.dreammaker.Babyshower.BabyShower_Place;
import com.example.dreammaker.Babyshower.BabyShower_foods;
import com.example.dreammaker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Babyshower extends Fragment {

LinearLayout layout;
    public Babyshower() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_babyshower, container, false);

        layout=view.findViewById(R.id.babydeco_linearLayout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), BabyShower_Decoraction.class);
                startActivity(intent);
            }
        });

        layout=view.findViewById(R.id.babyphoto_linearLayout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), BabyShower_Photo.class);
                startActivity(intent);
            }
        });

        layout=view.findViewById(R.id.babyplace_linearLayout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), BabyShower_Place.class);
                startActivity(intent);
            }
        });

        layout=view.findViewById(R.id.babyfood_linearLayout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), BabyShower_foods.class);
                startActivity(intent);
            }
        });

        return  view;
    }

}
