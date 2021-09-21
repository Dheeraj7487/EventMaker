package com.example.dreammaker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

public class Events_Booking_Details extends AppCompatActivity {

    EditText name, email, number, date, time;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_booking);

        name = findViewById(R.id.book_name);
        email = findViewById(R.id.book_email);
        number = findViewById(R.id.book_number);
        date = findViewById(R.id.book_date);
        time = findViewById(R.id.book_time);
        btn =findViewById(R.id.booking_detail);


                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (name.getText().toString().isEmpty()) {
                            name.setError("Enter Your Name");
                        }  else if (email.getText().toString().isEmpty()) {
                            email.setError("Enter Your Email");
                        } else if (number.getText().toString().isEmpty()) {
                            number.setError("Enter Your Number");
                        } else if (time.getText().toString().isEmpty()) {
                            time.setError("Enter Your Time");
                        } else if (date.getText().toString().isEmpty()) {
                            date.setError("Enter Your Address");
                        } else {
                            Toast.makeText(Events_Booking_Details.this, "Booking Sucessfully", Toast.LENGTH_SHORT).show();
                        }
                        if (new ConnectionCall(Events_Booking_Details.this).isConnectingToInternet()) {
                            new Booking_Detail().execute();
                        } else new ConnectionCall(Events_Booking_Details.this).connectiondetect();
                    }
                });

    }
    private class Booking_Detail extends AsyncTask<String, String, String> {

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(Events_Booking_Details.this);
            pd.setMessage("Loading...");
            pd.show();
        }

        //   @SuppressLint("WrongThread")
        @Override
        protected String doInBackground(String... strings) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", name.getText().toString());
            hashMap.put("number", number.getText().toString());
            hashMap.put("email", email.getText().toString());
            hashMap.put("date", date.getText().toString());
            hashMap.put("time", time.getText().toString());


            return new MakeServiceCall().MakeServiceCall("https://dreammakers1.000webhostapp.com/AddBookingd.php", MakeServiceCall.POST, hashMap);


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (pd.isShowing()) {
                pd.dismiss();
            }

            try {

                JSONObject jsonObject = new JSONObject(s);
                if (jsonObject.getString("Status").equalsIgnoreCase("True")) {
                    Toast.makeText(Events_Booking_Details.this, "Booking Successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Events_Booking_Details.this, Payment_Gateways.class);
                    startActivity(intent);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
