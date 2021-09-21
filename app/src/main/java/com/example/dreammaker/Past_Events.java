package com.example.dreammaker;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class Past_Events extends AppCompatActivity {
    int [] images={R.drawable.babyshowerdecofive,R.drawable.babyshowerdecofour,R.drawable.babyshowerdecothree,R.drawable.babyshowerdecotwo,R.drawable.babyshowerdecofive,R.drawable.babyshowerdecofive,R.drawable.babyshowerdecofive,R.drawable.babyshowerdecofive,R.drawable.babyshowerdecofive,R.drawable.babyshowerdecofive,R.drawable.babyshowerdecofive};
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past__events);

        gridView=findViewById(R.id.past_grid);
        CusAdapter cusAdapter=new CusAdapter(Past_Events.this,images);
        gridView.setAdapter(cusAdapter);

    }
}
