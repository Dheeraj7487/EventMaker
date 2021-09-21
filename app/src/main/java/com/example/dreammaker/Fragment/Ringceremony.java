package com.example.dreammaker.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dreammaker.R;
import com.example.dreammaker.RingCermony.RingCer_Decoration;
import com.example.dreammaker.RingCermony.RingCer_Foods;
import com.example.dreammaker.RingCermony.RingCer_Photo;
import com.example.dreammaker.RingCermony.RingCer_Place;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ringceremony extends Fragment {

    LinearLayout layout;

    public Ringceremony() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ringceremony, container, false);

        layout=view.findViewById(R.id.ring_deco_linearLayout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), RingCer_Decoration.class);
                startActivity(intent);
            }
        });

        layout=view.findViewById(R.id.ring_food_linearLayout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), RingCer_Foods.class);
                startActivity(intent);
            }
        });

        layout=view.findViewById(R.id.ring_photo_linearLayout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), RingCer_Photo.class);
                startActivity(intent);
            }
        });layout=view.findViewById(R.id.ring_place_linearLayout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), RingCer_Place.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
