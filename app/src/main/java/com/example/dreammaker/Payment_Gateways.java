package com.example.dreammaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Payment_Gateways extends AppCompatActivity {

    ImageView paytm,bhimupi,phonepay,m_pay,m_bhim,m_phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__gateways);

        paytm=findViewById(R.id.pay_paytm);
        bhimupi=findViewById(R.id.pay_bhimupi);
        phonepay=findViewById(R.id.pay_phonepay);

        m_pay=findViewById(R.id.m_paytm);
        m_bhim=findViewById(R.id.m_bhimupi);
        m_phone=findViewById(R.id.m_phonepay);

        paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m_pay.setVisibility(View.VISIBLE);
                m_bhim.setVisibility(View.INVISIBLE);
                m_phone.setVisibility(View.INVISIBLE);
            }
        });
        bhimupi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_pay.setVisibility(View.INVISIBLE);
                m_bhim.setVisibility(View.VISIBLE);
                m_phone.setVisibility(View.INVISIBLE);

            }
        });
        phonepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                m_pay.setVisibility(View.INVISIBLE);
                m_bhim.setVisibility(View.INVISIBLE);
                m_phone.setVisibility(View.VISIBLE);

            }
        });
    }
}
