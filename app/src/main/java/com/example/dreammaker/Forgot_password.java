package com.example.dreammaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Forgot_password extends AppCompatActivity {

    LinearLayout otp,submitotp;
    ImageView image;
    EditText email;
    Button btn,otpbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getSupportActionBar().hide();

        otp = findViewById(R.id.otp_linear);
        submitotp = findViewById(R.id.submit_otp_linear);

        image = findViewById(R.id.forgot_email_image);
        email = findViewById(R.id.forgot_email);
        otpbtn = findViewById(R.id.otp_btn);
        btn = findViewById(R.id.forgot_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                otp.setVisibility(View.INVISIBLE);
                submitotp.setVisibility(View.VISIBLE);

            }
        });

        otpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}