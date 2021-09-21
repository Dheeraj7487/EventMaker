package com.example.dreammaker.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dreammaker.R;
import com.example.dreammaker.Wedding.Decoration_Wedding;
import com.example.dreammaker.Wedding.Foods_Wedding;
import com.example.dreammaker.Wedding.Photo_Wedding;
import com.example.dreammaker.Wedding.Place_Wedding;

/**
 * A simple {@link Fragment} subclass.
 */
public class Wedding extends Fragment {

    LinearLayout layout;

    public Wedding() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_wedding, container, false);

        layout = view.findViewById(R.id.weddingdeco_linearLayout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Decoration_Wedding.class);
                startActivity(intent);
            }
        });

        layout = view.findViewById(R.id.weddingphoto_linearLayout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Photo_Wedding.class);
                startActivity(intent);
            }
        });

        layout = view.findViewById(R.id.weddingplace_linearLayout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Place_Wedding.class);
                startActivity(intent);
            }
        });

        layout = view.findViewById(R.id.weddingfood_linearLayout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Foods_Wedding.class);
                startActivity(intent);
            }
        });

        return view;



    }

}
