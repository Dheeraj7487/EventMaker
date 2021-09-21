package com.example.dreammaker.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dreammaker.Festivalparty.Festival_food;
import com.example.dreammaker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Festival extends Fragment {

LinearLayout layout;

    public Festival() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_festival, container, false);

        layout=view.findViewById(R.id.festivalfood_linearLayout);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Festival_food.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
