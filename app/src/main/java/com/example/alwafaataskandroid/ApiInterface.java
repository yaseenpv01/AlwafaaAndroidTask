package com.example.alwafaataskandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    //@FormUrlEncoded
    //@POST("/winsa/Services/add_update_address")
    //Call<AddrResponse> registration(@Field("building_name") String buildingname,
    //                                @Field("city_name") String cityname,
    //                                @Field("area") String areaname,
    //                                @Field("street_name") String streetname,
    //                                @Field("nearest_landmark") String nearestlandmark,
    //                                @Field("mobile_number") String phonenumber);


   @POST("winsa/Services/add_update_address")
    Call<AddrResponse> createPost(@Body AddrResponse addrResponse);


}
