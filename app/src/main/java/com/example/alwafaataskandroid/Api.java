package com.example.alwafaataskandroid;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static Retrofit retrofit=null;
    public static ApiInterface getclient(){
        if (retrofit == null){
            retrofit=new Retrofit.Builder()
                    .baseUrl("https://demo.softwarecompany.ae/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ApiInterface apiInterface=retrofit.create(ApiInterface.class);
        return apiInterface;
    }


}
