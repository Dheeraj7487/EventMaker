package com.example.dreammaker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapters extends RecyclerView.Adapter<MyAdapters.MyHolderData> {
    Context context;
     List<GetImagePojo> imagePojos;
     LayoutInflater layoutInflater;



    public MyAdapters(Context context, List<GetImagePojo> userlist) {

        this.context = context;
        this.imagePojos = userlist;
        layoutInflater=LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public MyHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=layoutInflater.inflate(R.layout.customhoteldataget,parent,false);

        return new MyHolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderData holder, int position) {

        holder.name.setText(imagePojos.get(position).getName());
        holder.place.setText(imagePojos.get(position).getPlace());
        holder.price.setText(imagePojos.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return imagePojos.size();
    }

    public class MyHolderData extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,place,price;


        public MyHolderData(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.hotel_image);
            name=itemView.findViewById(R.id.hotel_name);
            place=itemView.findViewById(R.id.hotel_address);
            price=itemView.findViewById(R.id.hotel_price);
        }
    }
    }
