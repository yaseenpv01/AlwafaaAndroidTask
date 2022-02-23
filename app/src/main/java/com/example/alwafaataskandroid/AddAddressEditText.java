package com.example.alwafaataskandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddAddressEditText extends AppCompatActivity {

    EditText mcity,marea,mstreetname,mbuildingname,mnearbylandmark,mphone;

    Button cnfmbtn,showdatabtn;

    String url="https://demo.softwarecompany.ae/winsa/Services/add_update_address";

    AddrResponse addrResponseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address_edit_text);

        mcity=findViewById(R.id.cityedittext);
        marea=findViewById(R.id.areaedittext);
        mstreetname=findViewById(R.id.streetedittext);
        mbuildingname=findViewById(R.id.buildingnameedittext);
        mnearbylandmark=findViewById(R.id.landmarkedittext);
        mphone=findViewById(R.id.phonenoedittext);

        showdatabtn=findViewById(R.id.showdatambtn);

        showdatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(AddAddressEditText.this,GetAddress.class);
                startActivity(intent);
            }
        });

        cnfmbtn=findViewById(R.id.confirmbtn);

        cnfmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String city=mcity.getText().toString();
                String area=marea.getText().toString();
                String streetname=mstreetname.getText().toString();
                String buildingname=mbuildingname.getText().toString();
                String nearbylandmark=mnearbylandmark.getText().toString();
                String phone=mphone.getText().toString();

                UploadData(city,area,streetname,buildingname,nearbylandmark,phone);



            }


        });


    }

    private void UploadData(String city, String area, String streetname, String buildingname, String nearbylandmark, String phone) {

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://demo.softwarecompany.ae/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Integer uid=1;

        ApiInterface apiInterface=retrofit.create(ApiInterface.class);
        AddrResponse addrResponse=new AddrResponse(city,area,streetname,buildingname,nearbylandmark,phone,uid);

        Call<AddrResponse> call= apiInterface.createPost(addrResponse);

        call.enqueue(new Callback<AddrResponse>() {
            @Override
            public void onResponse(Call<AddrResponse> call, Response<AddrResponse> response) {

                Toast.makeText(AddAddressEditText.this,"Data Added",Toast.LENGTH_LONG).show();

                AddrResponse respfrmapi=response.body();


            }

            @Override
            public void onFailure(Call<AddrResponse> call, Throwable t) {

                Toast.makeText(AddAddressEditText.this,"Error",Toast.LENGTH_LONG).show();

            }
        });


    }


}