package com.example.dreammaker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


class ABAdapter extends BaseAdapter {

    Context context;
    int [] image;
    String [] names;
    LayoutInflater inflater;

    public ABAdapter(HomePage homePage, String[] name, int[] imnage) {

        context=homePage;
        this.image=imnage;
        this.names=name;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount()

    {
        return names.length;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view1= inflater.inflate(R.layout.custemlists,null);

        ImageView imageView=view1.findViewById(R.id.us_img);
        LinearLayout linearLayout=view1.findViewById(R.id.ut_lin);
        TextView textView=view1.findViewById(R.id.us_tt);

        imageView.setImageResource(image[i]);
        textView.setText(names[i]);


        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                if (i == 0 )
                {
                    Intent intent=new Intent(context, Profile.class);
                    context.startActivity(intent);

                }

                if (i == 1)
                {
                    Intent intent=new Intent(context, Past_Events.class);
                    context.startActivity(intent);
                }


                if (i == 2)

                {
                    Intent intent=new Intent(context, Events.class);
                    context.startActivity(intent);
                }

                if (i == 3)
                {
                    Intent intent=new Intent(context, Hotels.class);
                    context.startActivity(intent);
                }

                if (i == 4)
                {
                    Intent intent=new Intent(context, FeedBack_Activity.class);
                    context.startActivity(intent);
                }

                if (i == 5)
                {
                    Intent intent=new Intent(context, ContactUs.class);
                    context.startActivity(intent);
                }

                if (i == 6)
                {
                    Intent intentInvite = new Intent(Intent.ACTION_SEND);
                    intentInvite.setType("text/plain");
                    String body = "Link to your app";
                    String subject = "Your Subject";
                    intentInvite.putExtra(Intent.EXTRA_SUBJECT, subject);
                    intentInvite.putExtra(Intent.EXTRA_TEXT, body);
                 context.startActivity(Intent.createChooser(intentInvite, "Share using"));
                }

                if (i==7){

                    AlertDialog.Builder builder=new AlertDialog.Builder(context);

                    builder.setTitle("Dream Maker");
                    builder.setMessage("Are You Want To Exit This App");
                    builder.setIcon(R.drawable.dream);

                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent intent=new Intent(context,Login.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            context.startActivity(intent);



                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent=new Intent(context,HomePage.class);
                            context.startActivity(intent);

                        }
                    });

                    builder.show();

                }
            }



        });

        return view1;

    }


}