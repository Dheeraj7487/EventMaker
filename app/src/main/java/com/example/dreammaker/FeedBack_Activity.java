package com.example.dreammaker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class FeedBack_Activity extends AppCompatActivity {

    EditText name,number,email,feedback;
    Button sbtn;
    String rating;
    ImageView back;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back_);
        getSupportActionBar().hide();


        name=findViewById(R.id.feed_name);
        number=findViewById(R.id.feed_number);
        email=findViewById(R.id.feed_email);
        feedback=findViewById(R.id.feed_feedbaks);
        ratingBar=findViewById(R.id.feed_rate);
        back=findViewById(R.id.feed_back);


        sbtn=findViewById(R.id.feed_submit_btn);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FeedBack_Activity.this,HomePage.class);
                startActivity(intent);
                onBackPressed();
            }
        });



        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rating= String.valueOf(ratingBar.getRating());
                Toast.makeText(FeedBack_Activity.this, rating, Toast.LENGTH_SHORT).show();

                if (new ConnectionCall(FeedBack_Activity.this).isConnectingToInternet())  {

                    new FeedBackInsert().execute();

                }
                else new ConnectionCall(FeedBack_Activity.this).connectiondetect();
            }
        });

    }

    private class FeedBackInsert extends AsyncTask<String,String,String> {

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(FeedBack_Activity.this);
            pd.setMessage("Loading...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put("name",name.getText().toString());
            hashMap.put("number",number.getText().toString());
            hashMap.put("email",email.getText().toString());
            hashMap.put("feedback",feedback.getText().toString());
            hashMap.put("rating",rating);

            return new MakeServiceCall().MakeServiceCall("https://dreammakers1.000webhostapp.com/feedback.php",MakeServiceCall.POST,hashMap);

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (pd.isShowing()){
                pd.dismiss();
            }

            try {

                JSONObject jsonObject=new JSONObject(s);
                if (jsonObject.getString("Status").equalsIgnoreCase("True")){
                    Toast.makeText(FeedBack_Activity.this, " Thanks For YOur FeedBack ", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(FeedBack_Activity.this,HomePage.class);
                    startActivity(intent);

                }

            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }
}
