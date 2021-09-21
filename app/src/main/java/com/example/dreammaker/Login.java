package com.example.dreammaker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class  Login extends AppCompatActivity {

    ImageView imageView;
    EditText email, password;
    TextView text, signupbtn;
    Button loginbtn;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imageView = findViewById(R.id.login_image);

        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        text = findViewById(R.id.login_forgotpassword);
        sp = getSharedPreferences(ConstantsSp.PREF, MODE_PRIVATE);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Forgot_password.class);
                startActivity(intent);
            }
        });

        loginbtn = findViewById(R.id.login_btn);
        signupbtn = findViewById(R.id.login_sigunp);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (email.getText().toString().isEmpty()) {
                    email.setError("Enter Your Email");
                }
                if (password.getText().toString().isEmpty()) {
                    password.setError("Enter Your Password");
                } else {

                    if (new ConnectionCall(Login.this).isConnectingToInternet()) {
                        new LoginPage().execute();
                    } else new ConnectionCall(Login.this).connectiondetect();

                }

            }
        });

    }

    private class LoginPage extends AsyncTask<String, String, String> {

        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(Login.this);
            pd.setMessage("Loading");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {


            HashMap hashMap = new HashMap();
            hashMap.put("email", email.getText().toString());
            hashMap.put("password", password.getText().toString());


            return new MakeServiceCall().MakeServiceCall("https://dreammakers1.000webhostapp.com/login.php", MakeServiceCall.POST, hashMap);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (pd.isShowing()) {
                pd.dismiss();
            }

            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(s);
                if (jsonObject.getString("Status").equalsIgnoreCase("True")) {
                    Toast.makeText(Login.this, jsonObject.getString("Message"), Toast.LENGTH_SHORT).show();
                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        sp.edit().putString(ConstantsSp.ID, object.getString("id")).commit();
                        sp.edit().putString(ConstantsSp.NAME, object.getString("name")).commit();
                        sp.edit().putString(ConstantsSp.NUMBER, object.getString("number")).commit();
                        sp.edit().putString(ConstantsSp.EMAIL, object.getString("email")).commit();
                        sp.edit().putString(ConstantsSp.ADDRESS, object.getString("address")).commit();

                        Intent intent = new Intent(Login.this, HomePage.class);
                        startActivity(intent);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}