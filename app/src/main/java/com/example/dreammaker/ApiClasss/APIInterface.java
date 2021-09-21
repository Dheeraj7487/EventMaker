package com.example.dreammaker.ApiClasss;

import com.example.dreammaker.GetImagePojo;
import com.example.dreammaker.Hotels;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    @FormUrlEncoded
    @POST("addplanner.php")
    Call <Planner_Add> ADD_CALL(@Field("username") String username,
                                @Field("usernumber")String usernumber,
                                @Field("relnumone") String relnumone,
                                @Field("relnumtwo")String relnumtwo,
                                @Field("personnum") String personnum,
                                @Field("eventsel")String eventsel,
                                @Field("eventpart") String eventpart);


    @GET("GetHotelDetails.php")
    Call<List<GetImagePojo>> getUserList();

}