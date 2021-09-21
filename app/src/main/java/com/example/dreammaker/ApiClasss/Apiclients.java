package com.example.dreammaker.ApiClasss;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclients {

    public static final String BaseUrl="https://dreammakers1.000webhostapp.com/";

    public static Retrofit retrofit=null;

    public static Retrofit getRetrofit(){
        retrofit =new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }


}
