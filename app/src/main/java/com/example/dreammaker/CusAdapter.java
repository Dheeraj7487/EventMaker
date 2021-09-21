package com.example.dreammaker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

class CusAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    int [] imag;

    public CusAdapter(Past_Events past_events, int[] images) {
       this.imag=images;
       context=past_events;
       inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imag.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1=inflater.inflate(R.layout.mydata,null);
        ImageView imageView=view1.findViewById(R.id.img_past);

        imageView.setImageResource(imag[i]);

        return view1;
    }
}
