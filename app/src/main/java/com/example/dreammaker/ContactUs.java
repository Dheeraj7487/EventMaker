package com.example.dreammaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ContactUs extends AppCompatActivity {

    ImageView imageView,calls,insta,fb,emails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        getSupportActionBar().hide();

        emails=findViewById(R.id.contact_email_icon);
        insta=findViewById(R.id.contact_instagram_icon);
        fb=findViewById(R.id.contact_facebook_icon);
        calls=findViewById(R.id.contact_call_icon);
        imageView=findViewById(R.id.contact_map_icon);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:23.0422°, 72.5643°"));
                startActivity(intent);
            }
        });

        calls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9664929489°"));
                startActivity(intent);
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/dreammaker866/?igshid=10hy3mb9itrma"));
                startActivity(intent);
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/dreammakerweddingplanner/"));
                startActivity(intent);
            }
        });

        emails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","dreammakersevent97@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

    }
}