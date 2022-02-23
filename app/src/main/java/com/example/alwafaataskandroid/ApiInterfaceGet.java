package com.example.alwafaataskandroid;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterfaceGet {

    @GET("winsa/Services/get_address")
    Call<AddrResponse> getAllAddress();
}
